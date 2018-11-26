package cn.novedu.mapper;

import cn.novedu.bean.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.TeachClazz;

@Mapper
public interface TeachClazzMapper {
    int insert(@Param("teachClazz") TeachClazz teachClazz);

    int insertSelective(@Param("teachClazz") TeachClazz teachClazz);

    int insertList(@Param("teachClazzs") List<TeachClazz> teachClazzs);

    int updateByPrimaryKeySelective(@Param("teachClazz") TeachClazz teachClazz);

    List<TeachClazz> findByClazzId(@Param("clazzId") String clazzId);

    Integer countByTeacherIdAndClazzId(@Param("teacherId")String teacherId,@Param("clazzId")String clazzId);


}
