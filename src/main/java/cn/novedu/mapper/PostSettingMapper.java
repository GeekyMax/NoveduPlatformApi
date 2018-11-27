package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.PostSetting;

@Mapper
public interface PostSettingMapper {
    int insert(@Param("postSetting") PostSetting postSetting);

    int updateByPrimaryKeySelective(@Param("postSetting") PostSetting postSetting);

    PostSetting findByPostId(@Param("postId") String postId);


}
