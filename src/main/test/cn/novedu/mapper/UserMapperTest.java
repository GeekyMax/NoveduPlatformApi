package cn.novedu.mapper;

import cn.novedu.bean.User;
import cn.novedu.bean.UserInfo;
import cn.novedu.constant.UserType;
import cn.novedu.param.PagingParam;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml", "classpath:spring-mvc.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    private Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Test
    public void insert() {
        User user = new User("max", "name", "", UserType.TEACHER);
        int i = userMapper.insert(user);
        logger.debug(user.getId());
    }

    @Test
    public void findByUserType() {
        List<User> users = userMapper.findByUserType(UserType.STUDENT,new PagingParam(2,3,"username desc"));
        users.forEach(user -> logger.debug(user.getName()));

    }
}