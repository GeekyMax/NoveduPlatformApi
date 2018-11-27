package cn.novedu.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Post {
    /**
     * 唯一编号id
     */
    private String id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 用户信息
     */
    private UserInfo userInfo;
    /**
     * 发布时间
     */
    private Date postTime;
    /**
     * 最后回复时间
     */
    private Date replyTime;
    /**
     * 回复数量
     */
    private Integer replyCount;
    /**
     * 所属班级信息
     */
    private Clazz clazz;
    private PostSetting postSetting;

    public Post(String title, String content, UserInfo userInfo, Clazz clazz, PostSetting postSetting) {
        this.title = title;
        this.content = content;
        this.userInfo = userInfo;
        this.clazz = clazz;
        this.postSetting = postSetting;
    }

    public Post() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public PostSetting getPostSetting() {
        return postSetting;
    }

    public void setPostSetting(PostSetting postSetting) {
        this.postSetting = postSetting;
    }
}
