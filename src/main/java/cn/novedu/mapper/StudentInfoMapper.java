package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.novedu.bean.StudentInfo;

@Mapper
public interface StudentInfoMapper {
    int insert(@Param("studentInfo") StudentInfo studentInfo);

    int insertSelective(@Param("studentInfo") StudentInfo studentInfo);

    int insertList(@Param("studentInfos") List<StudentInfo> studentInfos);

    int updateByPrimaryKeySelective(@Param("studentInfo") StudentInfo studentInfo);

    StudentInfo findById(@Param("id")String id);

    List<StudentInfo> findByTeamId(@Param("teamId")String teamId);

    StudentInfo findByUsername(@Param("username")String username);



}
