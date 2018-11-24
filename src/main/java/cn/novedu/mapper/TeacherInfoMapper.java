package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.novedu.bean.TeacherInfo;

@Mapper
public interface TeacherInfoMapper {
    int insert(@Param("teacherInfo") TeacherInfo teacherInfo);

    int insertSelective(@Param("teacherInfo") TeacherInfo teacherInfo);

    int insertList(@Param("teacherInfos") List<TeacherInfo> teacherInfos);

    int updateByPrimaryKeySelective(@Param("teacherInfo") TeacherInfo teacherInfo);
    TeacherInfo findById(@Param("id")String id);


}
