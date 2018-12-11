package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.FileInfo;

@Mapper
public interface FileInfoMapper {
    int insert(@Param("fileInfo") FileInfo fileInfo);

    int insertSelective(@Param("fileInfo") FileInfo fileInfo);

    int insertList(@Param("fileInfos") List<FileInfo> fileInfos);

    int updateByPrimaryKeySelective(@Param("fileInfo") FileInfo fileInfo);

    FileInfo findById(@Param("id") String id);


}
