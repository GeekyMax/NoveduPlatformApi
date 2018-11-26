package cn.novedu.mapper;

import cn.novedu.bean.StudentInfo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.Team;

@Mapper
public interface TeamMapper {
    int insert(@Param("team") Team team);

    int insertSelective(@Param("team") Team team);

    int insertList(@Param("teams") List<Team> teams);

    int updateByPrimaryKeySelective(@Param("team") Team team);

    int increaseMemberNumberById(@Param("id") String id);

    Team findById(@Param("id") String id);

    List<Team> findByClazzId(@Param("clazzId") String clazzId);

    Integer countByClazzId(@Param("clazzId") String clazzId);

    Integer countByIdAndClazzIdAndLeaderId(@Param("id") String id, @Param("clazzId") String clazzId, @Param("leaderId") String leaderId);


    int deleteByIdAndClazzIdAndLeaderId(@Param("id") String id, @Param("clazzId") String clazzId, @Param("leaderId") String leaderId);

    int deleteById(@Param("id") String id);


}
