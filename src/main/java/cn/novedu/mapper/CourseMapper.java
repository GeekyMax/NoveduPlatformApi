package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.novedu.bean.Course;

@Mapper
public interface CourseMapper {
    int insert(@Param("course") Course course);

    int insertSelective(@Param("course") Course course);

    int insertList(@Param("courses") List<Course> courses);

    int updateByPrimaryKeySelective(@Param("course") Course course);

    Course findById(@Param("id")String id);

    Course findByCode(@Param("code")String code);



}
