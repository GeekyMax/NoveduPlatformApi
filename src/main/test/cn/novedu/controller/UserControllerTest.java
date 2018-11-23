package cn.novedu.controller;

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
public class UserControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    private Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    // 通过:200
    @Test
    public void login() throws Exception {
        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"username\":\"max\",\"password\":\"password\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.meta.success").value(true))
                .andExpect(jsonPath("$.data.token").isNotEmpty())
                .andDo(print());

    }

    // 缺少密码:400
    @Test
    public void login2() throws Exception {
        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"username\":\"max\"}"))
                .andExpect(status().is(400))
                .andExpect(jsonPath("$.meta.success").value(false))
                .andDo(print());

    }

    // 密码错误:200
    @Test
    public void login3() throws Exception {
        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"username\":\"max\",\"password\":\"wrong\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.meta.success").value(false))
                .andDo(print());
    }

    // 验证interceptor
    // 无token:401
    @Test
    public void welcome() throws Exception {
        mockMvc.perform(get("/welcome").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(401));
    }

    // 带token:200
    @Test
    public void welcome2() throws Exception {
        mockMvc.perform(get("/welcome").accept(MediaType.APPLICATION_JSON).header("X-NOV-TOKEN", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ2aWZUZkxVZnpoIiwiaWF0IjoxNTQyOTc4NzUzLCJzdWIiOiJmMjQ4ZDI4ZWVlNTIxMWU4YmFkOTAyMDA0YzRmNGY1MCIsImV4cCI6MTU0Mjk4MjM1M30.R0jHZDqc02k0jdAps7udPJ8CiIHBUpi6s7TeZj87-ps"))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.data").value("welcome"));
    }

}