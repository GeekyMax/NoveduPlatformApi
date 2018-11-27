package cn.novedu.param;

public class ReplyCommentParam {
    private String content;
    private String replyId;
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
