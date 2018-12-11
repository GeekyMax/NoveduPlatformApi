package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.Bulletin;

@Mapper
public interface BulletinMapper {
    int insert(@Param("bulletin") Bulletin bulletin);

    List<Bulletin> findByClazzId(@Param("clazzId") String clazzId,
                                 @Param("pageNum") Integer pageNum,
                                 @Param("pageSize") Integer pageSize,
                                 @Param("orderBy") String orderBy);


}
