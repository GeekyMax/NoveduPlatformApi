package cn.novedu.param;

import javax.validation.constraints.NotNull;

/**
 * @author Max Huang
 */
public class ReplyCommentParam {
    @NotNull
    private String content;
    @NotNull
    private String replyId;
    @NotNull
    private String userId;

    public ReplyCommentParam(String content, String replyId, String userId) {
        this.content = content;
        this.replyId = replyId;
        this.userId = userId;
    }

    public ReplyCommentParam() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
