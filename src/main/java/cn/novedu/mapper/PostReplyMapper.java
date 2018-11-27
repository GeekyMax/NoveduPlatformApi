package cn.novedu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.novedu.bean.PostReply;

@Mapper
public interface PostReplyMapper {
    int insert(@Param("postReply") PostReply postReply);

    PostReply findById(@Param("id")String id);
    String findPostIdById(@Param("id")String id);
    List<PostReply> findByPostId(@Param("postId")String postId);


}
