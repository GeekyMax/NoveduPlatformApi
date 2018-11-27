package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.novedu.bean.ReplyComment;

@Mapper
public interface ReplyCommentMapper {
    int insert(@Param("replyComment") ReplyComment replyComment);
    List<ReplyComment> findByReplyId(@Param("replyId")String replyId);

    ReplyComment findById(@Param("id")String id);

}
