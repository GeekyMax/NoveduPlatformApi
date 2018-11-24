package cn.novedu.service;

import cn.novedu.bean.Course;
import cn.novedu.mapper.CourseMapper;
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
    public int insert(Course course) {
        return courseMapper.insert(course);
    }

    public int insert(List<Course> courseList) {
        return courseMapper.insertList(courseList);
    }

	public Course findById(String id){
		 return courseMapper.findById(id);
	}



}
