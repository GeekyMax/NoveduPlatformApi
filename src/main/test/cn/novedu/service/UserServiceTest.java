package cn.novedu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserServiceTest {
    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Test
    public void login() {
    }

    @Test
    public void signup() {
        String id = userService.signup("max", "password");
        logger.debug(id);
        assertNotNull(id);
        String id2 = userService.signup("max", "password");
        logger.debug("id2: " + id2);
        assertNull(id2);
    }
}