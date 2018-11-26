package cn.novedu.service;

import cn.novedu.bean.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional()
@ContextConfiguration(locations = {"classpath:application-context.xml", "classpath:spring-mvc.xml"})
public class ClazzServiceTest {
    @Autowired
    private ClazzService clazzService;
    private Logger logger = LoggerFactory.getLogger(ClazzServiceTest.class);
    @Rule
    public final ExpectedException exception = ExpectedException.none();

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

    /**
     * 合法插入
     */
    @Test
    public void insert11() {
        List<ClazzEnvironment> clazzEnvironmentList = IntStream.range(0, 2).mapToObj(i -> new ClazzEnvironment("周四" + i, "教四-10" + i)).collect(Collectors.toList());
        List<TeacherInfo> teacherInfoList = new ArrayList<>();
        teacherInfoList.add(new TeacherInfo("2e0705029e8a4f72ab4f4d32c2ea4b5d"));
        teacherInfoList.add(new TeacherInfo("19b4dd6fa3fa4153b727bb20ecc6ed7e"));
        ClazzSetting clazzSetting = new ClazzSetting();
        Clazz clazz = new Clazz("T(2018-2019)-COURSE1-1", new Course("668b08aef0be11e8b5b102004c4f4f50"), teacherInfoList, clazzEnvironmentList, clazzSetting);
        clazzService.insert(clazz);
    }

    /**
     * 合法案例12:course提供code
     */
    @Test
    public void insert12() {
        List<ClazzEnvironment> clazzEnvironmentList = IntStream.range(0, 2).mapToObj(i -> new ClazzEnvironment("周四" + i, "教四-10" + i)).collect(Collectors.toList());
        List<TeacherInfo> teacherInfoList = new ArrayList<>();
        teacherInfoList.add(new TeacherInfo("2e0705029e8a4f72ab4f4d32c2ea4b5d"));
        teacherInfoList.add(new TeacherInfo("19b4dd6fa3fa4153b727bb20ecc6ed7e"));
        ClazzSetting clazzSetting = new ClazzSetting();
        Clazz clazz = new Clazz("T(2018-2019)-COURSE2-1", new Course(null, "T(2018-2019)-COURSE2"), teacherInfoList, clazzEnvironmentList, clazzSetting);
        clazzService.insert(clazz);
    }

    /**
     * 合法案例13:teacher提供username
     */
    @Test
    public void insert13() {
        List<ClazzEnvironment> clazzEnvironmentList = IntStream.range(0, 2).mapToObj(i -> new ClazzEnvironment("周四" + i, "教四-10" + i)).collect(Collectors.toList());
        List<TeacherInfo> teacherInfoList = new ArrayList<>();
        teacherInfoList.add(new TeacherInfo(null, "4160102213", null));
        teacherInfoList.add(new TeacherInfo("19b4dd6fa3fa4153b727bb20ecc6ed7e"));
        ClazzSetting clazzSetting = new ClazzSetting();
        Clazz clazz = new Clazz("T(2018-2019)-COURSE1-1", new Course("668b08aef0be11e8b5b102004c4f4f50"), teacherInfoList, clazzEnvironmentList, clazzSetting);
        clazzService.insert(clazz);
    }

    /**
     * 非法案例01:course id 不存在
     */
    @Test
    public void insert01() {
        exception.expect(DataIntegrityViolationException.class);
        List<ClazzEnvironment> clazzEnvironmentList = IntStream.range(0, 2).mapToObj(i -> new ClazzEnvironment("周四" + i, "教四-10" + i)).collect(Collectors.toList());
        List<TeacherInfo> teacherInfoList = new ArrayList<>();
        teacherInfoList.add(new TeacherInfo("2e0705029e8a4f72ab4f4d32c2ea4b5d"));
        teacherInfoList.add(new TeacherInfo("19b4dd6fa3fa4153b727bb20ecc6ed7e"));
        ClazzSetting clazzSetting = new ClazzSetting();
        Clazz clazz = new Clazz("T(2018-2019)-COURSE1-2", new Course("notExist"), teacherInfoList, clazzEnvironmentList, clazzSetting);
        clazzService.insert(clazz);
    }

    /**
     * 非法案例02:course 无id 也无code
     */
    @Test
    public void insert02() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("course no id and code");
        List<ClazzEnvironment> clazzEnvironmentList = IntStream.range(0, 2).mapToObj(i -> new ClazzEnvironment("周四" + i, "教四-10" + i)).collect(Collectors.toList());
        List<TeacherInfo> teacherInfoList = new ArrayList<>();
        teacherInfoList.add(new TeacherInfo("2e0705029e8a4f72ab4f4d32c2ea4b5d"));
        teacherInfoList.add(new TeacherInfo("19b4dd6fa3fa4153b727bb20ecc6ed7e"));
        ClazzSetting clazzSetting = new ClazzSetting();
        Clazz clazz = new Clazz("T(2018-2019)-COURSE1-2", new Course(), teacherInfoList, clazzEnvironmentList, clazzSetting);
        clazzService.insert(clazz);
    }

    /**
     * 非法案例03:clazz 信息不完全
     */
    @Test
    public void insert03() {
        exception.expect(DataIntegrityViolationException.class);
        List<ClazzEnvironment> clazzEnvironmentList = IntStream.range(0, 2).mapToObj(i -> new ClazzEnvironment("周四" + i, "教四-10" + i)).collect(Collectors.toList());
        List<TeacherInfo> teacherInfoList = new ArrayList<>();
        teacherInfoList.add(new TeacherInfo("2e0705029e8a4f72ab4f4d32c2ea4b5d"));
        teacherInfoList.add(new TeacherInfo("19b4dd6fa3fa4153b727bb20ecc6ed7e"));
        ClazzSetting clazzSetting = new ClazzSetting();
        Clazz clazz = new Clazz(null, new Course("668b08aef0be11e8b5b102004c4f4f50"), teacherInfoList, clazzEnvironmentList, clazzSetting);
        clazzService.insert(clazz);
    }

    /**
     * 非法案例04:教师错误的id
     */
    @Test
    public void insert04() {
        exception.expect(DataIntegrityViolationException.class);
        List<ClazzEnvironment> clazzEnvironmentList = IntStream.range(0, 2).mapToObj(i -> new ClazzEnvironment("周四" + i, "教四-10" + i)).collect(Collectors.toList());
        List<TeacherInfo> teacherInfoList = new ArrayList<>();
        teacherInfoList.add(new TeacherInfo("errorid"));
        teacherInfoList.add(new TeacherInfo("errorid1"));
        ClazzSetting clazzSetting = new ClazzSetting();
        Clazz clazz = new Clazz("T(2018-2019)-COURSE1-1", new Course("668b08aef0be11e8b5b102004c4f4f50"), teacherInfoList, clazzEnvironmentList, clazzSetting);
        clazzService.insert(clazz);
    }

    /**
     * 非法案例05:clazzSetting 为null
     */
    @Test
    public void insert05() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("clazzSetting is empty");
        List<ClazzEnvironment> clazzEnvironmentList = IntStream.range(0, 2).mapToObj(i -> new ClazzEnvironment("周四" + i, "教四-10" + i)).collect(Collectors.toList());
        List<TeacherInfo> teacherInfoList = new ArrayList<>();
        teacherInfoList.add(new TeacherInfo("2e0705029e8a4f72ab4f4d32c2ea4b5d"));
        teacherInfoList.add(new TeacherInfo("19b4dd6fa3fa4153b727bb20ecc6ed7e"));
        Clazz clazz = new Clazz("T(2018-2019)-COURSE1-1", new Course("668b08aef0be11e8b5b102004c4f4f50"), teacherInfoList, clazzEnvironmentList, null);
        clazzService.insert(clazz);
    }

    /**
     * c测试插入学生,有对有错
     */
    @Test
    public void importClazzStudents() {
        List<StudentInfo> studentList = new ArrayList<>();
        // 1:standard
        studentList.add(new StudentInfo("07eb0fbc640e4604a9e1b491930e3280", null, null));
        // 0:error id
        studentList.add(new StudentInfo("07eb0fbc640e4604a9e1b491930e3281", null, null));
        // 1:use username
        studentList.add(new StudentInfo(null, "3160102216", null));
        // 0:all null
        studentList.add(new StudentInfo(null, null, null));
        // 0:error username
        studentList.add(new StudentInfo(null, "error", null));
        List<String> idList = clazzService.importClazzStudents(studentList, "b7b709b5f12611e8b5b102004c4f4f50");
        idList.forEach(s -> {
            logger.debug(s);
        });
        assertEquals(0, idList.size());

    }
}