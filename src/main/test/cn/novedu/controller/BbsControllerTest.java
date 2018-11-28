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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.io.Console;

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
    public void getPostsById() throws Exception {
        String clazzId = "02fd3297f18e11e8973400163e043b02";
        String postId = "13662ae3f1ea11e8973400163e043b02";
        mockMvc.perform(get("/bbs/" + clazzId + "/posts/" + postId).header(Constant.TOKEN_NAME, Constant.TOKEN_MAP.get("3160102210"))
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postPost() throws Exception {
        String userId = "56969bc9f18d11e8973400163e043b02";
        String clazzId = "02fd3297f18e11e8973400163e043b02";
        PostParam postParam = new PostParam("这是我的第一个帖子", "rt", userId, clazzId, PostPermission.ALL, "");
        String content = gson.toJson(postParam);
        mockMvc.perform(post("/bbs/" + clazzId + "/posts").header(Constant.TOKEN_NAME, Constant.TOKEN_MAP.get("3160102210"))
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postReplies() throws Exception {
        String content = "this is a reference";
        String userId = "56c235a2f18d11e8973400163e043b02";
        String postId = "13662ae3f1ea11e8973400163e043b02";
        String referenceId = "1ef989f4f23811e8973400163e043b02";
        PostReplyParam postReplyParam = new PostReplyParam(content, userId, postId, referenceId);
        content = gson.toJson(postReplyParam);
        mockMvc.perform(post("/bbs/" + clazzId + "/posts/" + postId + "/replies").header(Constant.TOKEN_NAME, Constant.TOKEN_MAP.get("3160102211"))
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postReplyComments() throws Exception {
        String content = "this is a comment";
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