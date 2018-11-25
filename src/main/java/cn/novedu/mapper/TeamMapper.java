package cn.novedu.mapper;

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

    Team findById(@Param("id") String id);


}
