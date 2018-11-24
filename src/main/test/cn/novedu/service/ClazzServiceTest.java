package cn.novedu.service;

import cn.novedu.bean.Clazz;
import cn.novedu.bean.ClazzSetting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml", "classpath:spring-mvc.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ClazzServiceTest {
    @Autowired
    private ClazzService clazzService;
    private Logger logger = LoggerFactory.getLogger(ClazzServiceTest.class);

    @Test
    public void find() {
        List<Clazz> clazzList = clazzService.find();
        clazzList.forEach(clazz -> {
            logger.debug("class.id:" + clazz.getId() + ";class.course.id:" + clazz.getCourse()
                    + ";class.team:" + clazz.getClazzSetting().getTeamAllowed());
            clazz.getTeachers().forEach(teacherInfo -> {
                logger.debug("teacher: " + teacherInfo.getName());
            });
            clazz.getClazzEnvironments().forEach(clazzEnvironment -> {
                logger.debug("time:" + clazzEnvironment.getTime() + ";place" + clazzEnvironment.getPlace());
            });
        });
    }
}