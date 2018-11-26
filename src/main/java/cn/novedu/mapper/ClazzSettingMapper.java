package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.novedu.bean.ClazzSetting;

@Mapper
public interface ClazzSettingMapper {
    int insert(@Param("clazzSetting") ClazzSetting clazzSetting);

    int insertSelective(@Param("clazzSetting") ClazzSetting clazzSetting);

    int insertList(@Param("clazzSettings") List<ClazzSetting> clazzSettings);

    int updateByPrimaryKeySelective(@Param("clazzSetting") ClazzSetting clazzSetting);
    ClazzSetting findByClazzId(@Param("clazzId")String clazzId);


}
