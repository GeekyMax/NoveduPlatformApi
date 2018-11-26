package cn.novedu.service;

import cn.novedu.constant.UserType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//@Transactional
public class UserServiceTest {
    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Test
    public void login() {
    }

    @Test
    public void signup() {
        String id = userService.signup("3160102266", "max", "password", UserType.TEACHER);
        logger.debug(id);
        assertNotNull(id);
    }

    @Test
    public void generateTokens() {
        StringBuilder stringBuilder=new StringBuilder();
        IntStream.range(10, 30).mapToObj(i -> "31601022" + i).forEach(s -> {
            String token = userService.login(s, "password");
            stringBuilder.append("TOKEN_MAP.put(\"" + s + "\",\"" + token + "\");\n");
            System.out.println("TOKEN_MAP.put(\"" + s + "\",\"" + token + "\");\n");
        });
        System.out.println(stringBuilder.toString());
    }
}