package cn.novedu.service;

import cn.novedu.bean.StudentInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml", "classpath:spring-mvc.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;
    private Logger logger = LoggerFactory.getLogger(StudentServiceTest.class);

    @Test
    public void findById() {

    }

    @Test
    @Rollback(false)
    public void insertStudent() {
        IntStream.range(10, 30).forEach(i -> {
            try {
                String id = studentService.insertStudent("31601022" + i, "student" + i, "password");
                logger.debug("result id for teacher" + i + ": " + id);
            } catch (Exception e) {
                logger.error("error", e);
            }
        });
    }
}