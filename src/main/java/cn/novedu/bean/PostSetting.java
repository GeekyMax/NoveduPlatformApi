package cn.novedu.bean;

import cn.novedu.constant.PostPermission;

public class PostSetting {
    /**
     * 主题帖id
     */
    private String postId;
    /**
     * 本贴权限
     */
    private PostPermission postPermission;
    /**
     * 所属队伍id
     */
    private String teamId;

    public PostSetting(PostPermission postPermission, String teamId) {
        this.postPermission = postPermission;
        this.teamId = teamId;
    }

    public PostSetting() {
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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
