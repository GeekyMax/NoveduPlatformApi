package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.ClazzResource;

/**
 * @author Max Huang
 */
@Mapper
public interface ClazzResourceMapper {
    /**
     * 插入一个clazzResource
     *
     * @param clazzResource
     * @return 返回成功的结果个数
     */
    int insert(@Param("clazzResource") ClazzResource clazzResource);
    ClazzResource findById(@Param("id")String id);


}
