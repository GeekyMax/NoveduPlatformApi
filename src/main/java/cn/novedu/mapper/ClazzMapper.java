package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.Clazz;

@Mapper
public interface ClazzMapper {
    int insert(@Param("clazz") Clazz clazz);

    int insertSelective(@Param("clazz") Clazz clazz);

    int insertList(@Param("clazzs") List<Clazz> clazzs);

    int updateByPrimaryKeySelective(@Param("clazz") Clazz clazz);

    Clazz findById(@Param("id") String id);

    List<Clazz> find();

    List<Clazz> findByStudentId(@Param("studentId") String studentId);

    List<Clazz> findByTeacherId(@Param("teacherId") String teacherId);

    Clazz findByClazzIdAndStudentId(@Param("clazzId") String clazzId, @Param("studentId") String studentId);

    Clazz findByClazzIdAndTeacherId(@Param("clazzId") String clazzId, @Param("teacherId") String teacherId);
}
