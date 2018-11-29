package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;

/**
 * @author Max Huang
 */
@Mapper
public interface SysMapper {
    Boolean existColumn(@Param("tableName")String tableName, @Param("columnName")String columnName);
}

