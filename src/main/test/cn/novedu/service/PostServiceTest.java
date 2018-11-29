package cn.novedu.service;

import cn.novedu.bean.Post;
import cn.novedu.bean.PostReply;
import cn.novedu.bean.ReplyComment;
import cn.novedu.constant.PostPermission;
import cn.novedu.param.PostParam;
import cn.novedu.param.PostReplyParam;
import cn.novedu.param.ReplyCommentParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional()
@ContextConfiguration(locations = {"classpath:application-context.xml", "classpath:spring-mvc.xml"})
public class PostServiceTest {
    @Autowired
    private BbsService postService;
    private Logger logger = LoggerFactory.getLogger(PostServiceTest.class);

    @Test
//    @Rollback(false)
    public void insertPost() {
        String userId = "56969bc9f18d11e8973400163e043b02";
        String clazzId = "02fd3297f18e11e8973400163e043b02";
        String teamId = "9302f6d3f18e11e8973400163e043b02";
        PostParam postParam = new PostParam("4.只有9302f6小组可以看哦", "rt", userId, clazzId, PostPermission.TEAM, teamId);
        Post post = postService.insertPost(postParam);
        if (post != null) {
            logger.debug(post.getId() + ": " + post.getTitle());
        }
        assertNotNull(post);
    }

    @Test
    public void insertPost1() {
    }

    @Test
    @Rollback(false)
    public void insertPostReply() {
        String content = "this is a reference";
        String userId = "56c235a2f18d11e8973400163e043b02";
        String postId = "13662ae3f1ea11e8973400163e043b02";
        String referenceId = "1ef989f4f23811e8973400163e043b02";
        PostReplyParam postReplyParam = new PostReplyParam(content, userId, postId,referenceId);
        PostReply postReply = postService.insertPostReply(postReplyParam);
        logger.debug("post reply:" + postReply.getId());
        assertNotNull(postReply.getId());
    }

    @Test
    @Rollback(false)
    public void insertReplyComment() {
        String content = "this is a good idea";
        String replyId = "1ef989f4f23811e8973400163e043b02";
        String userId = "56c235a2f18d11e8973400163e043b02";
        ReplyCommentParam replyCommentParam = new ReplyCommentParam(content, replyId, userId);
        ReplyComment replyComment = postService.insertReplyComment(replyCommentParam);
        logger.debug("comment id:" + replyComment.getId());
        assertNotNull(replyComment.getId());
    }

    @Test
    public void insertPost2() {
    }
}