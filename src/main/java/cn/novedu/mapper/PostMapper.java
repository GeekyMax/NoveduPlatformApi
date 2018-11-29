package cn.novedu.mapper;

import cn.novedu.constant.PostPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.Post;

/**
 * @author Max Huang
 */
@Mapper
public interface PostMapper {
    int insert(@Param("post") Post post);

    Integer increaseReplyCountById(@Param("id") String id);

    Post findById(@Param("id") String id);

    Boolean judgeStudentIdAndPostIdInSameClazz(@Param("userId") String userId, @Param("postId") String postId);

    Boolean judgeTeacherIdAndPostIdInSameClazz(@Param("userId") String userId, @Param("postId") String postId);

    List<Post> findByClazzIdAndPostPermission(@Param("clazzId") String clazzId, @Param("postPermission") PostPermission postPermission);

    List<Post> findByClazzIdAndPostPermissionWithPaging(
            @Param("clazzId") String clazzId,
            @Param("postPermission") PostPermission postPermission,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize,
            @Param("orderBy") String orderBy
    );

    List<Post> findByTeamId(@Param("teamId") String teamId);

    List<Post> findByTeamIdWithPaging(
            @Param("teamId") String teamId,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize,
            @Param("orderBy") String orderBy);
}
