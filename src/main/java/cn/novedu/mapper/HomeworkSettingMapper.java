package cn.novedu.mapper;

import cn.novedu.param.HomeworkSettingParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.HomeworkSetting;

@Mapper
public interface HomeworkSettingMapper {

    int insertSelective(@Param("homeworkSetting") HomeworkSetting homeworkSetting);

    int updateByPrimaryKeySelective(@Param("homeworkSetting") HomeworkSetting homeworkSetting);

    HomeworkSetting findByHomeworkId(@Param("homeworkId") String homeworkId);


}
