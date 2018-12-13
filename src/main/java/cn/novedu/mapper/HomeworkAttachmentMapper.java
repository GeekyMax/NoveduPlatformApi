package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.novedu.bean.HomeworkAttachment;

@Mapper
public interface HomeworkAttachmentMapper {
    int insert(@Param("homeworkAttachment") HomeworkAttachment homeworkAttachment);
    List<HomeworkAttachment> findByHomeworkId(@Param("homeworkId")String homeworkId);


}
