package cn.novedu.service;

import cn.novedu.bean.Course;
import cn.novedu.bean.User;
import cn.novedu.jdbc.id.IdGenerator;
import cn.novedu.mapper.CourseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Max Huang
 */
@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private IdGenerator idGenerator;
    private Logger logger = LoggerFactory.getLogger(CourseService.class);

    public int insert(Course course) {
        return courseMapper.insertSelective(course);
    }

    public int insert(List<Course> courseList) {
        int count = 0;
        for (Course course : courseList) {
            try {
                count = count + insert(course);
            } catch (Exception e) {
                logger.error("error", e);
            }
        }
        return count;
    }

    public String insertCourse(String name, String code) {
        Course course = new Course(name, code);
        int result = courseMapper.insertSelective(course);
        if (result != 1) {
            return null;
        } else {
            return course.getId();
        }
    }

    public Course findById(String id) {
        return courseMapper.findById(id);
    }
}
