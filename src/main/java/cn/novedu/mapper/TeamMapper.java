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

    int increaseMemberNumberById(@Param("id") String id);

    Team findById(@Param("id") String id);

    List<Team> findByClazzId(@Param("clazzId") String clazzId);

    List<Team> findByClazzIdWithPaging(@Param("clazzId") String clazzId,
                                       @Param("pageNum") Integer pageNum,
                                       @Param("pageSize") Integer pageSize,
                                       @Param("orderBy") String orderBy);
    String findClazzIdById(@Param("id")String id);


    Integer countByClazzId(@Param("clazzId") String clazzId);

    Integer countByIdAndClazzIdAndLeaderId(@Param("id") String id, @Param("clazzId") String clazzId, @Param("leaderId") String leaderId);

    Boolean existByIdAndLeaderId(@Param("id")String id, @Param("leaderId")String leaderId);
    int deleteByIdAndClazzIdAndLeaderId(@Param("id") String id, @Param("clazzId") String clazzId, @Param("leaderId") String leaderId);

    int deleteByIdAndLeaderId(@Param("id") String id, @Param("leader") String leaderId);
    
    
    int deleteById(@Param("id") String id);


}
