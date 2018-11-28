package cn.novedu.param;

import javax.validation.constraints.NotNull;

public class PostReplyParam {
    /**
     * 回帖内容
     */
    @NotNull
    private String content;
    /**
     * 回帖用户id
     */
    @NotNull
    private String userId;
    /**
     * 主帖id
     */
    @NotNull
    private String postId;

    /**
     * 引用的回帖的id
     */
    private String referenceId;

    public PostReplyParam() {
    }

    public PostReplyParam(String content, String userId, String postId, String referenceId) {
        this.content = content;
        this.userId = userId;
        this.postId = postId;
        this.referenceId = referenceId;
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

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}
