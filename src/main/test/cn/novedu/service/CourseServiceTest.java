package cn.novedu.service;

import cn.novedu.bean.Course;
import cn.novedu.jdbc.id.IdGenerator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml", "classpath:spring-mvc.xml"})
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//@Transactional
public class CourseServiceTest {
    @Autowired
    private CourseService courseService;
    @Autowired
    private IdGenerator idGenerator;
    private Logger logger = LoggerFactory.getLogger(CourseServiceTest.class);

    /**
     * 测试 insert(Course)
     */
    @Test
    public void insert() {
        IntStream.range(1, 10).forEach(i -> {
            try {
                Course course = new Course("软件工程专业课" + i, "T(2018-2019)-COURSE" + i);
                courseService.insert(course);
                logger.debug("course" + i + " id: " + course.getId());
            } catch (Exception e) {
                logger.error("error", e);
                fail();
            }
        });
    }

    /**
     * 测试批量插入insert(List<Course>)
     */
    @Test
    public void insert1() {
        List<Course> courseList =
                IntStream.range(1, 10).mapToObj(i -> new Course("软件工程专业课" + i, "T(2018-2019)-COURSE" + i))
                        .collect(Collectors.toList());
        int result = courseService.insert(courseList);
        logger.debug("success" + result);
        courseList.forEach(course -> logger.debug("course id: " + course.getId()));
    }
}