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

    List<Clazz> findByStudentIdWithPaging(@Param("studentId") String studentId,
                                          @Param("pageNum") Integer pageNum,
                                          @Param("pageSize") Integer pageSize,
                                          @Param("orderBy") String orderBy);

    List<Clazz> findByTeacherId(@Param("teacherId") String teacherId);

    List<Clazz> findByTeacherIdWithPaging(@Param("teacherId") String teacherId,
                                          @Param("pageNum") Integer pageNum,
                                          @Param("pageSize") Integer pageSize,
                                          @Param("orderBy") String orderBy);

    Clazz findByClazzIdAndStudentId(@Param("clazzId") String clazzId, @Param("studentId") String studentId);

    Clazz findByClazzIdAndTeacherId(@Param("clazzId") String clazzId, @Param("teacherId") String teacherId);

    Integer countById(@Param("id") String id);


}
