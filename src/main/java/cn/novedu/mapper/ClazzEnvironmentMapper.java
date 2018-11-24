package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.novedu.bean.ClazzEnvironment;

@Mapper
public interface ClazzEnvironmentMapper {
    int insert(@Param("clazzEnvironment") ClazzEnvironment clazzEnvironment);

    int insertSelective(@Param("clazzEnvironment") ClazzEnvironment clazzEnvironment);

    int insertList(@Param("clazzEnvironments") List<ClazzEnvironment> clazzEnvironments);

    int updateByPrimaryKeySelective(@Param("clazzEnvironment") ClazzEnvironment clazzEnvironment);
    List<ClazzEnvironment> findByClazzId(@Param("clazzId")String clazzId);


}
