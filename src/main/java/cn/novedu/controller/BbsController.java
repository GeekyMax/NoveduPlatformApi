package cn.novedu.controller;

import cn.novedu.bean.*;
import cn.novedu.constant.Constant;
import cn.novedu.param.PostParam;
import cn.novedu.param.PostReplyParam;
import cn.novedu.param.ReplyCommentParam;
import cn.novedu.result.AllPostResult;
import cn.novedu.result.PostResult;
import cn.novedu.security.PermissionException;
import cn.novedu.service.ClazzService;
import cn.novedu.service.PostService;
import cn.novedu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Max Huang
 */
@RestController
public class BbsController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private ClazzService clazzService;
    private Logger logger = LoggerFactory.getLogger(BbsController.class);

    @RequestMapping(value = "/bbs/{bbs-id}/posts", method = RequestMethod.GET)
    public Response getPosts(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("bbs-id") String bbsId) {
        String userId = userService.getUserId(token);
        List<Post> allPosts = postService.getAllPostByClazzId(userId, bbsId);
        List<Post> teamPosts = postService.getTeamPostByClazzId(userId, bbsId);
        Clazz clazz = clazzService.findByClazzIdAndUserId(bbsId, userId);
        AllPostResult allPostResult = new AllPostResult(clazz, allPosts, teamPosts);
        return new Response().success(allPostResult);
    }

    @RequestMapping(value = "/posts/{post-id}", method = RequestMethod.GET)
    public Response getPostsById(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("post-id") String postid) {
        String userId = userService.getUserId(token);
        PostResult postResult = postService.getPostById(userId, postid);
        if (postResult != null) {
            return new Response().success(postResult);
        } else {
            return new Response().failure();
        }
    }

    @RequestMapping(value = "/bbs/{bbs-id}/posts", method = RequestMethod.POST)
    public Response postPost(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("bbs-id") String bbsId, @RequestBody PostParam postParam) {
        String userId = userService.getUserId(token);
        if (!userId.equals(postParam.getUserId())) {
            return new Response().failure();
        }
        Post post = postService.insertPost(postParam);

        if (post != null) {
            return new Response().success(post);
        } else {
            return new Response().failure();
        }
    }

    @RequestMapping(value = "/posts/{post-id}/replies", method = RequestMethod.POST)
    public Response postReplies(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("post-id") String postId, @Valid @RequestBody PostReplyParam postReplyParam) {
        String userId = userService.getUserId(token);
        if (!userId.equals(postReplyParam.getUserId())) {
            throw new PermissionException();
        }
        PostReply postReply = postService.insertPostReply(postReplyParam);

        if (postReply != null) {
            return new Response().success(postReply);
        } else {
            return new Response().failure();
        }
    }

    @RequestMapping(value = "/replies/{reply-id}/comments", method = RequestMethod.POST)
    public Response postReplyComments(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("reply-id") String replyId, @Valid @RequestBody ReplyCommentParam replyCommentParam) {
        String userId = userService.getUserId(token);
        if (!userId.equals(replyCommentParam.getUserId())) {
            throw new PermissionException();
        }
        ReplyComment replyComment = postService.insertReplyComment(replyCommentParam);
        if (replyComment != null) {
            return new Response().success(replyComment);
        } else {
            return new Response().failure();
        }
    }
}
