package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.AttachClazz;

@Mapper
public interface AttachClazzMapper {
    int insert(@Param("attachClazz") AttachClazz attachClazz);

    int insertSelective(@Param("attachClazz") AttachClazz attachClazz);

    int insertList(@Param("attachClazzs") List<AttachClazz> attachClazzs);

    int updateByPrimaryKeySelective(@Param("attachClazz") AttachClazz attachClazz);

    List<AttachClazz> findByStudentId(@Param("studentId") String studentId);

    Integer countByStudentIdAndClazzId(@Param("studentId") String studentId, @Param("clazzId") String clazzId);

}
