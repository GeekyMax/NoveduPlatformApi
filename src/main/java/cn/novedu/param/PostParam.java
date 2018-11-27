package cn.novedu.param;

import cn.novedu.constant.PostPermission;

import javax.validation.constraints.NotNull;

/**
 * @author Max Huang
 */
public class PostParam {
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private String userId;
    @NotNull
    private String clazzId;
    @NotNull
    private PostPermission postPermission;
    @NotNull
    private String teamId;

    public PostParam(@NotNull String title, @NotNull String content, @NotNull String userId, @NotNull String clazzId, @NotNull PostPermission postPermission, @NotNull String teamId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.clazzId = clazzId;
        this.postPermission = postPermission;
        this.teamId = teamId;
    }

    public PostParam() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }

    public PostPermission getPostPermission() {
        return postPermission;
    }

    public void setPostPermission(PostPermission postPermission) {
        this.postPermission = postPermission;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
