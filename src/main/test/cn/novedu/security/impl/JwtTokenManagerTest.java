package cn.novedu.security.impl;

import cn.novedu.security.TokenManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class JwtTokenManagerTest {
    @Autowired
    TokenManager tokenManager;
    private Logger logger = LoggerFactory.getLogger(JwtTokenManagerTest.class);

    @Test
    public void createToken() {
        String token = tokenManager.createToken("f248d28eee5211e8bad902004c4f4f50");
        logger.debug("token is: " + token);
        assertEquals(token, " eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ0WTR2dkhhN0FQIiwiaWF0IjoxNTQyOTA0ODQ1LCJzdWIiOiJmMjQ4ZDI4ZWVlNTIxMWU4YmFkOTAyMDA0YzRmNGY1MCIsImV4cCI6MTU0MjkwODQ0NX0.9f01DjqSmUImOGJMR6IXWRgYsu002swmEsShjbBLMyc");
    }

    @Test
    public void checkToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ0WTR2dkhhN0FQIiwiaWF0IjoxNTQyOTA0ODQ1LCJzdWIiOiJmMjQ4ZDI4ZWVlNTIxMWU4YmFkOTAyMDA0YzRmNGY1MCIsImV4cCI6MTU0MjkwODQ0NX0.9f01DjqSmUImOGJMR6IXWRgYsu002swmEsShjbBLMyc";
        boolean isValid = tokenManager.checkToken(token);
        assertTrue(isValid);
        String falseToken = "ayJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ0WTR2dkhhN0FQIiwiaWF0IjoxNTQyOTA0ODQ1LCJzdWIiOiJmMjQ4ZDI4ZWVlNTIxMWU4YmFkOTAyMDA0YzRmNGY1MCIsImV4cCI6MTU0MjkwODQ0NX0.9f01DjqSmUImOGJMR6IXWRgYsu002swmEsShjbBLMyc";
        assertFalse(tokenManager.checkToken(falseToken));
    }

    @Test
    public void getUserId() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ0WTR2dkhhN0FQIiwiaWF0IjoxNTQyOTA0ODQ1LCJzdWIiOiJmMjQ4ZDI4ZWVlNTIxMWU4YmFkOTAyMDA0YzRmNGY1MCIsImV4cCI6MTU0MjkwODQ0NX0.9f01DjqSmUImOGJMR6IXWRgYsu002swmEsShjbBLMyc";
        String id = tokenManager.getUserId(token);
        logger.debug("id:" + id);
        assertEquals(id, "f248d28eee5211e8bad902004c4f4f50");
    }
}