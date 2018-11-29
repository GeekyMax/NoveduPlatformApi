package cn.novedu.controller;

import cn.novedu.bean.*;
import cn.novedu.constant.Constant;
import cn.novedu.jdbc.paging.PagingManager;
import cn.novedu.param.PagingParam;
import cn.novedu.param.PostParam;
import cn.novedu.param.PostReplyParam;
import cn.novedu.param.ReplyCommentParam;
import cn.novedu.result.AllPostResult;
import cn.novedu.result.PostResult;
import cn.novedu.security.PermissionException;
import cn.novedu.service.ClazzService;
import cn.novedu.service.BbsService;
import cn.novedu.service.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Max Huang
 */
@RestController
public class BbsController {
    @Autowired
    private BbsService bbaService;
    @Autowired
    private UserService userService;
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private PagingManager pagingManager;
    private Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(BbsController.class);

    /**
     * 查询本班级的所有posts.
     * 返回三部分内容:
     * 1.clazz信息
     * 2.所有权限为ALL的帖子(scope=TEAM时不返回
     * 3.小组内可见的帖子(scope=ALL时不返回
     * 支持条件查询(page,per_page,order,sort),但是建议在使用条件查询时,使用scope参数限定返回ALL或是TEAM的posts
     *
     * @param token    用户token
     * @param bbsId    所查询的bbsId
     * @param scope    查询范围(TEAM or ALL) 默认全部
     * @param pageNum  第几页
     * @param pageSize 每页几条
     * @param order    升序asc还是降序desc
     * @param sort     按什么列排序
     * @return 返回List of Post(分为ALL和TEAM) clazz信息
     */
    @RequestMapping(value = "/bbs/{bbs-id}/posts", method = RequestMethod.GET)
    public Response getPosts(
            @RequestHeader(Constant.TOKEN_NAME) String token,
            @PathVariable("bbs-id") String bbsId,
            @RequestParam("scope") String scope,
            @RequestParam(value = "page", defaultValue = "0") int pageNum,
            @RequestParam(value = "per_page", defaultValue = "0") int pageSize,
            @RequestParam(value = "order", defaultValue = "desc") String order,
            @RequestParam(value = "sort", defaultValue = "post_time") String sort
    ) {
        String userId = userService.getUserId(token);
        String orderBy = pagingManager.handleOrderBy("post", sort, order);
        if (orderBy == null) {
            orderBy = "post_time asc";
        }
        PagingParam pagingParam = new PagingParam(pageNum, pageSize, orderBy);
        logger.debug(gson.toJson(pagingParam));
        List<Post> allPosts = new ArrayList<>();
        List<Post> teamPosts = new ArrayList<>();
        if (scope == null) {
            allPosts = bbaService.getAllPostByClazzId(userId, bbsId, pagingParam);
            teamPosts = bbaService.getTeamPostByClazzId(userId, bbsId, pagingParam);
        } else if ("team".equals(scope.trim().toLowerCase())) {
            teamPosts = bbaService.getTeamPostByClazzId(userId, bbsId, pagingParam);
        } else if ("all".equals(scope.trim().toLowerCase())) {
            allPosts = bbaService.getAllPostByClazzId(userId, bbsId, pagingParam);
        } else {
            allPosts = bbaService.getAllPostByClazzId(userId, bbsId, pagingParam);
            teamPosts = bbaService.getTeamPostByClazzId(userId, bbsId, pagingParam);
        }
        Clazz clazz = clazzService.findByClazzIdAndUserId(bbsId, userId);
        AllPostResult allPostResult = new AllPostResult(clazz, allPosts, teamPosts);
        return new Response().success(allPostResult);
    }

    /**
     * 根据postId返回post信息,支持对于评论信息的过滤
     * 默认返回所有的reply
     * 每个reply附带最多10条的reply comment
     * 更多的reply comment 请调用 replies/:id/comments
     *
     * @param token       用户token
     * @param postId      请求的主帖id
     * @param withReplies 是否需要带回复,default true
     * @param pageNum     第几页
     * @param pageSize    每页几条
     * @param order       升序asc还是降序desc
     * @param sort        按什么列排序
     * @return PostResult 包括post 和 list of reply
     */
    @RequestMapping(value = "/posts/{post-id}", method = RequestMethod.GET)
    public Response getPostsById(
            @RequestHeader(Constant.TOKEN_NAME) String token,
            @PathVariable("post-id") String postId,
            @RequestParam(value = "with_replies", defaultValue = "true") boolean withReplies,
            @RequestParam(value = "page", defaultValue = "0") int pageNum,
            @RequestParam(value = "per_page", defaultValue = "0") int pageSize,
            @RequestParam(value = "order", defaultValue = "reply_time") String order,
            @RequestParam(value = "sort", defaultValue = "asc") String sort
    ) {
        String userId = userService.getUserId(token);
        String orderBy = pagingManager.handleOrderBy("post", sort, order);
        if (orderBy == null) {
            orderBy = "reply_time asc";
        }
        PagingParam pagingParam = new PagingParam(pageNum, pageSize, orderBy);
        PostResult postResult = bbaService.getPostById(userId, postId, withReplies, pagingParam);
        if (postResult != null) {
            return new Response().success(postResult);
        } else {
            return new Response().failure();
        }
    }

    /**
     * 返回指定post的回帖列表replyList,支持信息过滤
     * 默认返回所有replies
     * 每个reply最多带10条comment
     * 更多的reply comment 请调用 replies/:id/comments
     *
     * @param token    用户token
     * @param postId   请求的主帖id
     * @param pageNum  第几页
     * @param pageSize 每页几条
     * @param order    升序asc还是降序desc
     * @param sort     按什么列排序
     * @return 返回List of PostReply
     */
    @RequestMapping(value = "/post/{post-id}/replies", method = RequestMethod.GET)
    public Response getReplies(
            @RequestHeader(Constant.TOKEN_NAME) String token,
            @PathVariable("post-id") String postId,
            @RequestParam(value = "page", defaultValue = "0") int pageNum,
            @RequestParam(value = "per_page", defaultValue = "0") int pageSize,
            @RequestParam(value = "order", defaultValue = "reply_time") String order,
            @RequestParam(value = "sort", defaultValue = "asc") String sort
    ) {
        String userId = userService.getUserId(token);
        String orderBy = pagingManager.handleOrderBy("post", sort, order);
        if (orderBy == null) {
            orderBy = "reply_time asc";
        }
        PagingParam pagingParam = new PagingParam(pageNum, pageSize, orderBy);
        List<PostReply> postReplies = bbaService.getReplies(userId, postId, pagingParam);
        if (postReplies != null) {
            return new Response().success(postReplies);
        } else {
            return new Response().failure();
        }
    }

    /**
     * 查询指定reply的comments
     * 支持条件查询,默认返回所有的comments
     *
     * @param token    用户token
     * @param replyId  所查询的回帖id
     * @param pageNum  第几页
     * @param pageSize 每页几条
     * @param order    升序asc还是降序desc
     * @param sort     按什么列排序
     * @return 成功则返回 List of Comment
     */
    @RequestMapping(value = "/replies/{reply-id}/comments", method = RequestMethod.GET)
    public Response getComments(
            @RequestHeader(Constant.TOKEN_NAME) String token,
            @PathVariable("reply-id") String replyId,
            @RequestParam(value = "page", defaultValue = "0") int pageNum,
            @RequestParam(value = "per_page", defaultValue = "0") int pageSize,
            @RequestParam(value = "order", defaultValue = "comment_time") String order,
            @RequestParam(value = "sort", defaultValue = "asc") String sort
    ) {
        String userId = userService.getUserId(token);
        String orderBy = pagingManager.handleOrderBy("post", sort, order);
        if (orderBy == null) {
            orderBy = "comment_time asc";
        }
        PagingParam pagingParam = new PagingParam(pageNum, pageSize, orderBy);
        List<ReplyComment> replyComments = bbaService.gerComments(userId, replyId, pagingParam);
        if (replyComments != null) {
            return new Response().success(replyComments);
        } else {
            return new Response().failure();
        }
    }

    /**
     * 在指定论坛发布帖子
     *
     * @param token     用户token
     * @param bbsId     所在的论坛id
     * @param postParam 传入的帖子参数,其中的clazzId会被bbs-id覆盖
     * @return 成功则返回发布的帖子对象
     */
    @RequestMapping(value = "/bbs/{bbs-id}/posts", method = RequestMethod.POST)
    public Response postPost(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("bbs-id") String bbsId, @RequestBody PostParam postParam) {
        String userId = userService.getUserId(token);
        // 校验token属于请求的userId
        if (!userId.equals(postParam.getUserId())) {
            return new Response().failure();
        }
        postParam.setClazzId(bbsId);
        Post post = bbaService.insertPost(postParam);

        if (post != null) {
            return new Response().success(post);
        } else {
            return new Response().failure();
        }
    }

    /**
     * 对指定帖子发布回帖
     *
     * @param token          用户token
     * @param postId         回帖的主帖id
     * @param postReplyParam 传入的回帖参数,其中的postId会被路径中的id覆盖
     * @return 成功则返回所发表的回帖
     */
    @RequestMapping(value = "/posts/{post-id}/replies", method = RequestMethod.POST)
    public Response postReplies(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("post-id") String postId, @Valid @RequestBody PostReplyParam postReplyParam) {
        String userId = userService.getUserId(token);
        // 校验token属于请求的userId
        if (!userId.equals(postReplyParam.getUserId())) {
            throw new PermissionException();
        }
        postReplyParam.setPostId(postId);
        PostReply postReply = bbaService.insertPostReply(postReplyParam);

        if (postReply != null) {
            return new Response().success(postReply);
        } else {
            return new Response().failure();
        }
    }

    /**
     * 对指定回帖发表评论
     *
     * @param token             用户token
     * @param replyId           需要评论的回帖id
     * @param replyCommentParam 回复参数
     * @return 成功则返回回复对象
     */
    @RequestMapping(value = "/replies/{reply-id}/comments", method = RequestMethod.POST)
    public Response postReplyComments(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("reply-id") String replyId, @Valid @RequestBody ReplyCommentParam replyCommentParam) {
        String userId = userService.getUserId(token);
        // 校验token属于请求的userId
        if (!userId.equals(replyCommentParam.getUserId())) {
            throw new PermissionException();
        }
        // 覆盖参数中的replyId
        replyCommentParam.setReplyId(replyId);
        ReplyComment replyComment = bbaService.insertReplyComment(replyCommentParam);
        if (replyComment != null) {
            return new Response().success(replyComment);
        } else {
            return new Response().failure();
        }
    }
}
