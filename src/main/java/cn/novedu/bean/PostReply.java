package cn.novedu.bean;

import cn.novedu.param.PostReplyParam;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class PostReply {
    /**
     * 唯一id
     */
    private String id;
    /**
     * 主贴id
     */
    private String postId;
    /**
     * 引用回复id
     */
    private String referenceId;
    /**
     * 回复内容
     */
    private String content;
    /**
     * 用户信息
     */
    private UserInfo userInfo;
    /**
     * 回帖时间
     */
    private Date replyTime;
    /**
     * 楼中楼列表
     */
    private List<ReplyComment> replyCommentList;

    public PostReply(PostReplyParam postReplyParam) {
        this.postId = postReplyParam.getPostId();
        this.userInfo = new UserInfo(postReplyParam.getUserId(), null, null);
        this.referenceId = null;
        this.content = postReplyParam.getContent();
        this.referenceId=postReplyParam.getReferenceId();
    }

    public PostReply() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public List<ReplyComment> getReplyCommentList() {
        return replyCommentList;
    }

    public void setReplyCommentList(List<ReplyComment> replyCommentList) {
        this.replyCommentList = replyCommentList;
    }
}
