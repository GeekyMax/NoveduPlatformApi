package cn.novedu.controller;

import cn.novedu.constant.Constant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml", "classpath:spring-mvc.xml"})
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ClazzControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    private Logger logger = LoggerFactory.getLogger(ClazzControllerTest.class);

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * 学生token测试
     *
     * @throws Exception
     */
    @Test
    public void classes() throws Exception {
        mockMvc.perform(get("/classes").header("X-NOV-TOKEN", Constant.TOKEN_MAP.get("3160102220"))
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.meta.success").value(true))
                .andDo(print());
    }

    /**
     * 教师token测试
     *
     * @throws Exception
     */
    @Test
    public void classes2() throws Exception {
        mockMvc.perform(get("/classes").header("X-NOV-TOKEN", Constant.TEACHER_TOKEN)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.meta.success").value(true))
                .andDo(print());
    }

    /**
     * teacher:200
     *
     * @throws Exception
     */
    @Test
    public void classes11() throws Exception {
        mockMvc.perform(get("/classes/53f5f3f7efe311e8bad902004c4f4f50").header("X-NOV-TOKEN", Constant.TEACHER_TOKEN)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.meta.success").value(true))
                .andDo(print());
    }

    /**
     * teacher:404
     *
     * @throws Exception
     */
    @Test
    public void classes12() throws Exception {
        mockMvc.perform(get("/classes/74d979b3efe311e8bad902004c4f4f50").header("X-NOV-TOKEN", Constant.TEACHER_TOKEN)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.meta.success").value(false))
                .andDo(print());
    }

    /**
     * student:200
     *
     * @throws Exception
     */
    @Test
    public void classes13() throws Exception {
        mockMvc.perform(get("/classes/53f5f3f7efe311e8bad902004c4f4f50").header("X-NOV-TOKEN", Constant.STUDENT_TOKEN)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.meta.success").value(true))
                .andDo(print());
    }

    /**
     * student:404
     *
     * @throws Exception
     */
    @Test
    public void classes14() throws Exception {
        mockMvc.perform(get("/classes/6d55605fefe311e8bad902004c4f4f50").header("X-NOV-TOKEN", Constant.STUDENT_TOKEN)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.meta.success").value(false))
                .andDo(print());
    }

}