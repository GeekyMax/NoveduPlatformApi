package cn.novedu.mapper;

import cn.novedu.bean.Clazz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml", "classpath:spring-mvc.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ClazzMapperTest {
    private Logger logger = LoggerFactory.getLogger(ClazzMapperTest.class);
    @Autowired
    private ClazzMapper clazzMapper;

    @Test
    public void findById() {
        Clazz clazz = clazzMapper.findById("a3240649efd111e8bad902004c4f4f50");
        logger.debug(clazz.getId() + " course name:" + clazz.getCourse().getName());
        assertEquals(clazz.getCourse().getId(), "230be0a7efcf11e8bad902004c4f4f50");
    }

    @Test
    public void find() {
        List<Clazz> clazzList = clazzMapper.find();
        clazzList.forEach(clazz -> logger.debug("class Code:" + clazz.getCode() + "Course name:" + clazz.getCourse().getName()));
        assertTrue(clazzList.size() >= 1);
    }

    @Test
    public void findByStudentId() {
        List<Clazz> clazzList = clazzMapper.findByStudentId("446159d5fec34f788b9175f9353ee8ca");
        clazzList.forEach(clazz -> {
            logger.debug("class code:" + clazz.getCode() + ";course name:" + clazz.getCourse().getName());
        });
        assertTrue(clazzList.size() >= 2);
    }
}