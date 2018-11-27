package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.AttendClazz;

/**
 * @author Max Huang
 */
@Mapper
public interface AttendClazzMapper {
    int insert(@Param("attendClazz") AttendClazz attendClazz);

    int insertSelective(@Param("attendClazz") AttendClazz attendClazz);

    int insertList(@Param("attendClazzs") List<AttendClazz> attendClazzs);

    int updateByPrimaryKeySelective(@Param("attendClazz") AttendClazz attendClazz);

    Integer countByStudentIdAndClazzId(@Param("studentId") String studentId, @Param("clazzId") String clazzId);

    Boolean judgeStudentInClazz(@Param("studentId") String studentId, @Param("clazzId") String clazzId);

    Integer countByTeamId(@Param("teamId") String teamId);

    Integer countByStudentIdAndClazzIdAndTeamId(@Param("studentId") String studentId, @Param("clazzId") String clazzId, @Param("teamId") String teamId);

    Boolean existByStudentIdAndTeamId(@Param("studentId") String studentId, @Param("teamId") String teamId);


    int updateTeamIdByStudentIdAndClazzId(@Param("updatedTeamId") String updatedTeamId, @Param("studentId") String studentId, @Param("clazzId") String clazzId);

    AttendClazz findByStudentIdAndClazzId(@Param("studentId") String studentId, @Param("clazzId") String clazzId);

}
