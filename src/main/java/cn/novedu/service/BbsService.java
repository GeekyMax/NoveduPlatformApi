package cn.novedu.service;

import cn.novedu.bean.*;
import cn.novedu.constant.PostPermission;
import cn.novedu.constant.UserType;
import cn.novedu.mapper.*;
import cn.novedu.param.PagingParam;
import cn.novedu.param.PostParam;
import cn.novedu.param.PostReplyParam;
import cn.novedu.param.ReplyCommentParam;
import cn.novedu.result.PostResult;
import cn.novedu.security.PermissionException;
import cn.novedu.security.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Max Huang
 */
@Service
public class BbsService {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostSettingMapper postSettingMapper;
    @Autowired
    private AttendClazzMapper attendClazzMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PostReplyMapper postReplyMapper;
    @Autowired
    private ReplyCommentMapper replyCommentMapper;
    @Autowired
    private TeachClazzMapper teachClazzMapper;
    private Logger logger = LoggerFactory.getLogger(BbsService.class);

    /**
     * 获得该班级下的所有权限为ALL的帖子
     *
     * @param userId
     * @param clazzId
     * @return
     */
    public List<Post> getAllPostByClazzId(String userId, String clazzId, PagingParam pagingParam) {
        if (pagingParam == null) {
            pagingParam = new PagingParam();
        }
        UserType userType = userMapper.findUserTypeById(userId);
        Boolean result;
        if (userType == UserType.STUDENT) {
            result = attendClazzMapper.judgeStudentInClazz(userId, clazzId);
        } else {
            result = teachClazzMapper.judgeTeacherInClazz(userId, clazzId);
        }
        if (result == null || !result) {
            return null;
        } else {
            return postMapper.findByClazzIdAndPostPermissionWithPaging(
                    clazzId, PostPermission.ALL, pagingParam.getPageNum(), pagingParam.getPageSize(), pagingParam.getOrderBy());
        }
    }

    /**
     * 获得该班级下的所有权限为TEAM的帖子(当然你得在这个队伍中
     * 教师可以获得所有的帖子
     *
     * @param userId
     * @param clazzId
     * @return
     */
    public List<Post> getTeamPostByClazzId(String userId, String clazzId, PagingParam pagingParam) {
        if (pagingParam == null) {
            pagingParam = new PagingParam();
        }
        UserType userType = userMapper.findUserTypeById(userId);
        if (userType == UserType.STUDENT) {
            AttendClazz attendClazz = attendClazzMapper.findByStudentIdAndClazzId(userId, clazzId);
            if (attendClazz == null) {
                return null;
            }
            String teamId = attendClazz.getTeamId();
            if (teamId == null || "".equals(teamId)) {
                return null;
            }
            return postMapper.findByTeamIdWithPaging(
                    teamId, pagingParam.getPageNum(), pagingParam.getPageSize(), pagingParam.getOrderBy());

        } else {
            Boolean result = teachClazzMapper.judgeTeacherInClazz(userId, clazzId);
            if (result != null && result) {
                return postMapper.findByClazzIdAndPostPermissionWithPaging(
                        clazzId, PostPermission.TEAM, pagingParam.getPageNum(), pagingParam.getPageSize(), pagingParam.getOrderBy());
            } else {
                return null;
            }
        }
    }

    /**
     * 根据post id返回result,包括post和reply list
     *
     * @param userId
     * @param postId
     * @param pagingParam
     * @return
     */
    public PostResult getPostById(String userId, String postId, boolean withReplies, PagingParam pagingParam) {
        if (pagingParam == null) {
            pagingParam = new PagingParam();
        }
        if (!checkPermission(userId, postId, true)) {
            throw new PermissionException("permission denied");
        }
        Post post = postMapper.findById(postId);
        List<PostReply> postReplies = new ArrayList<>();
        if (withReplies) {
            postReplies = postReplyMapper.findByPostIdWithPaging(postId, pagingParam.getPageNum(), pagingParam.getPageSize(), pagingParam.getOrderBy());
        }
        return new PostResult(post, postReplies);
    }

    public List<PostReply> getReplies(String userId, String postId, PagingParam pagingParam) {
        if (pagingParam == null) {
            pagingParam = new PagingParam();
        }
        if (!checkPermission(userId, postId, true)) {
            throw new PermissionException("permission denied");
        }
        return postReplyMapper.findByPostIdWithPaging(postId, pagingParam.getPageNum(), pagingParam.getPageSize(), pagingParam.getOrderBy());
    }

    public List<ReplyComment> gerComments(String userId, String replyId, PagingParam pagingParam) {
        if (pagingParam == null) {
            pagingParam = new PagingParam();
        }
        String postId = postReplyMapper.findPostIdById(replyId);
        if (!checkPermission(userId, postId, true)) {
            throw new PermissionException("permission denied");
        }
        return replyCommentMapper.findByReplyIdWithPaging(replyId, pagingParam.getPageNum(), pagingParam.getPageSize(), pagingParam.getOrderBy());
    }

    /**
     * 发布帖子,对外接口
     *
     * @param postParam
     * @return
     */
    public Post insertPost(PostParam postParam) {
        //检查用户权限
        Integer result = 0;
        if (postParam.getPostPermission() == PostPermission.TEAM) {
            result = attendClazzMapper.countByStudentIdAndClazzIdAndTeamId(postParam.getUserId(), postParam.getClazzId(), postParam.getTeamId());
        } else if (postParam.getPostPermission() == PostPermission.ALL) {
            postParam.setTeamId("");
            result = attendClazzMapper.countByStudentIdAndClazzId(postParam.getUserId(), postParam.getClazzId());
        }
        if (result != 1) {
            throw new PermissionException("not in this team or class");
        }
        return insertPost(new Post(postParam.getTitle(),
                postParam.getContent(),
                new UserInfo(postParam.getUserId(), null, null),
                new Clazz(postParam.getClazzId()),
                new PostSetting(postParam.getPostPermission(), postParam.getTeamId()))
        );
    }

    /**
     * 回复帖子,对外接口
     *
     * @param postReplyParam 回帖信息
     * @return 成功则返回reply对象
     */
    public PostReply insertPostReply(PostReplyParam postReplyParam) {
        if (!checkPermission(postReplyParam.getUserId(), postReplyParam.getPostId(), false)) {
            throw new PermissionException("reply permission denied");
        }
        PostReply postReply = new PostReply(postReplyParam);
        PostReply returnedPostReply = insertPostReply(postReply);
        logger.debug("postId:" + returnedPostReply.getPostId() + "replyId:" + returnedPostReply.getId());
        return returnedPostReply;
    }

    /**
     * 回复回帖,对外接口
     *
     * @param replyCommentParam
     * @return
     */
    public ReplyComment insertReplyComment(ReplyCommentParam replyCommentParam) {
        String postId = postReplyMapper.findPostIdById(replyCommentParam.getReplyId());
        if (!checkPermission(replyCommentParam.getUserId(), postId, false)) {
            throw new PermissionException("comment permission denied");
        }
        ReplyComment replyComment = new ReplyComment(replyCommentParam);
        return insertReplyComment(postId, replyComment);
    }

    /**
     * 判断用户是否有在本帖回复的权限
     *
     * @param userId
     * @param postId
     * @param defaultTeacherPermission
     * @return
     */
    private boolean checkPermission(String userId, String postId, boolean defaultTeacherPermission) {
        try {
            UserType userType = userMapper.findUserTypeById(userId);
            Boolean inSameClazz;
            if (userType == UserType.STUDENT) {
                inSameClazz = postMapper.judgeStudentIdAndPostIdInSameClazz(userId, postId);
            } else {
                inSameClazz = postMapper.judgeTeacherIdAndPostIdInSameClazz(userId, postId);
            }
            if (!inSameClazz) {
                return false;
            }
            PostSetting postSetting = postSettingMapper.findByPostId(postId);
            //如果允许班级内的所有人访问,即返回true
            if (postSetting.getPostPermission() == PostPermission.ALL) {
                return true;
            }
            //否则进一步判断是否在小组之内
            if (userType == UserType.TEACHER) {
                return defaultTeacherPermission;
            }
            String allowedTeamId = postSetting.getTeamId();
            return attendClazzMapper.existByStudentIdAndTeamId(userId, allowedTeamId);

        } catch (Exception e) {
            logger.error("error", e);
            return false;
        }
    }

    /**
     * 对内接口
     * 该函数调用前请确保参数经过核验
     *
     * @param post
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public Post insertPost(Post post) {
        int result = postMapper.insert(post);
        if (result != 1) {
            throw new ServiceException();
        }
        PostSetting postSetting = post.getPostSetting();
        postSetting.setPostId(post.getId());
        result = postSettingMapper.insert(postSetting);
        if (result != 1) {
            throw new ServiceException();
        }
        post = postMapper.findById(post.getId());
        return post;
    }

    /**
     * 完成一条回帖请求,包含多个原子操作,需要事务管理
     *
     * @param postReply
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public PostReply insertPostReply(PostReply postReply) {
        postReplyMapper.insert(postReply);
        logger.debug(postReply.getPostId());
        Integer result = postMapper.increaseReplyCountById(postReply.getPostId());
        if (result == null || result != 1) {
            logger.debug("error", result);
            throw new ServiceException();
        }
        return postReplyMapper.findById(postReply.getId());
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public ReplyComment insertReplyComment(String postId, ReplyComment replyComment) {
        replyCommentMapper.insert(replyComment);
        logger.debug(postId);
        Integer result = postMapper.increaseReplyCountById(postId);
        if (result == null || result != 1) {
            logger.debug("error increase!");
            throw new ServiceException();
        }
        return replyCommentMapper.findById(replyComment.getId());
    }
}
