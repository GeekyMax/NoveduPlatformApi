package cn.novedu.controller;

import cn.novedu.constant.Constant;
import cn.novedu.constant.PostPermission;
import cn.novedu.param.PostParam;
import cn.novedu.param.PostReplyParam;
import cn.novedu.param.ReplyCommentParam;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.io.Console;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml", "classpath:spring-mvc.xml"})
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class BbsControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    private Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(BbsControllerTest.class);
    private String clazzId = "02fd3297f18e11e8973400163e043b02";

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Test
    public void getPosts() throws Exception {
        String clazzId = "02fd3297f18e11e8973400163e043b02";
        mockMvc.perform(get("/bbs/" + clazzId + "/posts").header(Constant.TOKEN_NAME, Constant.TOKEN_MAP.get("3160102210"))
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getPosts1() throws Exception {
        String clazzId = "02fd3297f18e11e8973400163e043b02";
        mockMvc.perform(get("/bbs/" + clazzId + "/posts?scope=ALL&page=2&per_page=10&sort=post_time&order=desc").header(Constant.TOKEN_NAME, Constant.TOKEN_MAP.get("3160102210"))
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getPostsById() throws Exception {
        String postId = "13662ae3f1ea11e8973400163e043b02";
        mockMvc.perform(get("/posts/" + postId
//                + "?page=2&per_page=10&sort=reply_time&order=desc"
        ).header(Constant.TOKEN_NAME, Constant.TOKEN_MAP.get("3160102210"))
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
//    @Rollback(false)
    public void postPost() throws Exception {
        for (int i = 0; i < 40; i++) {
            String userId = "56969bc9f18d11e8973400163e043b02";
            String clazzId = "02fd3297f18e11e8973400163e043b02";
            PostParam postParam = new PostParam("测试帖子" + i, "", userId, clazzId, PostPermission.ALL, "");
            String content = gson.toJson(postParam);
            mockMvc.perform(post("/bbs/" + clazzId + "/posts").header(Constant.TOKEN_NAME, Constant.TOKEN_MAP.get("3160102210"))
                    .accept(APPLICATION_JSON_UTF8)
                    .contentType(APPLICATION_JSON_UTF8)
                    .content(content))
                    .andDo(print())
                    .andExpect(status().isOk());
        }
    }

    @Test
    @Rollback(false)
    public void postReplies() throws Exception {
        for (int i = 1; i < 100; i++) {
            String content = "测试回帖" + i;
            String userId = "56c235a2f18d11e8973400163e043b02";
            String postId = "13662ae3f1ea11e8973400163e043b02";
            String referenceId = null;
            PostReplyParam postReplyParam = new PostReplyParam(content, userId, postId, referenceId);
            content = gson.toJson(postReplyParam);
            mockMvc.perform(post("/posts/" + postId + "/replies").header(Constant.TOKEN_NAME, Constant.TOKEN_MAP.get("3160102211"))
                    .accept(APPLICATION_JSON_UTF8)
                    .contentType(APPLICATION_JSON_UTF8)
                    .content(content))
                    .andDo(print())
                    .andExpect(status().isOk());
        }
    }

    @Test
    @Rollback(false)
    public void postReplyComments() throws Exception {
        for (int i = 0; i < 100; i++) {
            String content = "测试评论" + i;
            String userId = "56c235a2f18d11e8973400163e043b02";
            String replyId = "1ef989f4f23811e8973400163e043b02";
            ReplyCommentParam replyCommentParam = new ReplyCommentParam(content, replyId, userId);
            content = gson.toJson(replyCommentParam);
            mockMvc.perform(post("/replies/" + replyId + "/comments").header(Constant.TOKEN_NAME, Constant.TOKEN_MAP.get("3160102211"))
                    .accept(APPLICATION_JSON_UTF8)
                    .contentType(APPLICATION_JSON_UTF8)
                    .content(content))
                    .andDo(print())
                    .andExpect(status().isOk());
        }
    }
}