package cn.novedu.bean;

import cn.novedu.param.ReplyCommentParam;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @author Max Huang
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class ReplyComment {
    /**
     * 唯一id
     */
    private String id;
    /**
     * 回帖id
     */
    private String replyId;
    /**
     * 用户信息
     */
    private UserInfo userInfo;
    /**
     * 回复内容
     */
    private String content;
    /**
     * 回复时间
     */
    private Date commentTime;

    public ReplyComment(ReplyCommentParam replyCommentParam) {
        this.replyId = replyCommentParam.getReplyId();
        this.userInfo = new UserInfo(replyCommentParam.getUserId(), null, null);
        this.content = replyCommentParam.getContent();
    }

    public ReplyComment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}
