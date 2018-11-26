package cn.novedu.mapper;

import cn.novedu.constant.TeamRequestState;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.TeamRequest;

/**
 * @author Max Huang
 */
@Mapper
public interface TeamRequestMapper {
    int insert(@Param("teamRequest") TeamRequest teamRequest);

    TeamRequest findById(@Param("id") String id);


    List<TeamRequest> findByTeamId(@Param("teamId") String teamId);

    int updateTeamRequestStateById(@Param("updatedTeamRequestState") TeamRequestState updatedTeamRequestState, @Param("id") String id);

    Integer countByStudentIdAndTeamIdAndTeamRequestState(@Param("studentId") String studentId, @Param("teamId") String teamId, @Param("teamRequestState") String teamRequestStateString);


}
