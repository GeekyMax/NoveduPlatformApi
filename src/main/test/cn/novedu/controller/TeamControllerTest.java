package cn.novedu.controller;

import cn.novedu.bean.StudentInfo;
import cn.novedu.bean.Team;
import cn.novedu.bean.TeamRequest;
import cn.novedu.constant.Constant;
import cn.novedu.param.RequestHandlerParam;
import com.google.gson.Gson;
import org.junit.After;
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

import static cn.novedu.constant.Constant.TOKEN_MAP;
import static cn.novedu.constant.Constant.TOKEN_NAME;
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
public class TeamControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    private Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(TeamControllerTest.class);
    private String clazzId = "02fd3297f18e11e8973400163e043b02";

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    /**
     * @throws Exception
     */
    @Test
    public void postTeam() throws Exception {
        String content = gson.toJson(new Team("postTeam", "post team", clazzId, new StudentInfo()));
        mockMvc.perform(post("/classes/" + clazzId + "/teams").header(TOKEN_NAME, TOKEN_MAP.get("3160102212"))
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isNotEmpty());
    }

    @Test
    public void getTeams() throws Exception {
        mockMvc.perform(get("/classes/" + clazzId + "/teams").header(Constant.TOKEN_NAME, TOKEN_MAP.get("3160102210")).accept(APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isNotEmpty());
    }

    @Test
    public void getTeamById() throws Exception {
        String teamId = "7a6f26bbf14911e8b5b102004c4f4f50";
        mockMvc.perform(get("/classes/" + clazzId + "/teams/" + teamId).header(Constant.TOKEN_NAME, TOKEN_MAP.get("3160102210")).accept(APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isNotEmpty());
    }

    @Test
    public void deleteTeamById() throws Exception {
        String teamId = "7a6f26bbf14911e8b5b102004c4f4f50";
        mockMvc.perform(delete("/classes/" + clazzId + "/teams/" + teamId).header(Constant.TOKEN_NAME, TOKEN_MAP.get("3160102210")).accept(APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.meta.success").value(true));
    }

    @Test
    public void updateTeamById() throws Exception {
        String content = gson.toJson(new Team("postTeam", "post team", clazzId, new StudentInfo()));
        String teamId = "7a6f26bbf14911e8b5b102004c4f4f50";
        mockMvc.perform(put("/classes/" + clazzId + "/teams/" + teamId).header(TOKEN_NAME, TOKEN_MAP.get("3160102210"))
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isNotEmpty());
    }

    @Test
    @Rollback(false)
    public void postTeamRequests() throws Exception {
        String teamId = "9302f6d3f18e11e8973400163e043b02";
        mockMvc.perform(post("/classes/" + clazzId + "/teams/" + teamId + "/request").header(TOKEN_NAME, TOKEN_MAP.get("3160102212"))
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andDo(print());
    }

    @Test
    public void getTeamRequests() throws Exception {
        String teamId = "7a6f26bbf14911e8b5b102004c4f4f50";
        mockMvc.perform(get("/classes/" + clazzId + "/teams/" + teamId + "/request").header(TOKEN_NAME, TOKEN_MAP.get("3160102210"))
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isNotEmpty());

    }

    @Test
    @Rollback(false)
    public void handleRequest() throws Exception {
        String teamId = "7a6f26bbf14911e8b5b102004c4f4f50";
        String requestId = "ef465fc9f18811e8977702004c4f4f50";
        String content = gson.toJson(new RequestHandlerParam(requestId, false));
        mockMvc.perform(post("/classes/" + clazzId + "/teams/" + teamId + "/request/handler").header(TOKEN_NAME, TOKEN_MAP.get("3160102210"))
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk());
    }
}