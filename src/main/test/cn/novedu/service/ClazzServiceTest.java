package cn.novedu.service;

import cn.novedu.bean.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @Test
    public void insert() {
        List<ClazzEnvironment> clazzEnvironmentList = IntStream.range(0, 2).mapToObj(i -> new ClazzEnvironment("周四" + i, "教四-10" + i)).collect(Collectors.toList());
        List<TeacherInfo> teacherInfoList = new ArrayList<>();
        teacherInfoList.add(new TeacherInfo("2e0705029e8a4f72ab4f4d32c2ea4b5d"));
        teacherInfoList.add(new TeacherInfo("19b4dd6fa3fa4153b727bb20ecc6ed7e"));
        ClazzSetting clazzSetting = new ClazzSetting();
        Clazz clazz = new Clazz("T(2018-2019)-COURSE1-1", new Course("668b08aef0be11e8b5b102004c4f4f50"), teacherInfoList, clazzEnvironmentList, clazzSetting);
        clazzService.insert(clazz);
    }
}