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

import java.util.stream.IntStream;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml", "classpath:spring-mvc.xml"})
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//@Transactional
public class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;
    private Logger logger = LoggerFactory.getLogger(TeacherServiceTest.class);

    @Test
    public void insertTeacher() {
        IntStream.range(10, 30).forEach(i -> {
            try {
                String id = teacherService.insertTeacher("41601022" + i, "teacher" + i, "password");
                logger.debug("result id for teacher" + i + ": " + id);
            } catch (Exception e) {
                logger.error("error", e);
            }
        });
    }
}