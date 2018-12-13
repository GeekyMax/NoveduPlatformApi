package cn.novedu.mapper;

import cn.novedu.constant.HomeworkState;

import cn.novedu.param.HomeworkSettingParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.Homework;

@Mapper
public interface HomeworkMapper {
    int insertSelective(@Param("homework") Homework homework);

    int updateByPrimaryKeySelective(@Param("homework") Homework homework);

    List<Homework> findByClazzId(@Param("clazzId") String clazzId);

    List<Homework> findByClazzIdAndHomeworkState(@Param("clazzId") String clazzId, @Param("homeworkState") HomeworkState homeworkState);

    Homework findById(@Param("id") String id);

}
