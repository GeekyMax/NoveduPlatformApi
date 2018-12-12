package cn.novedu.bean;

import cn.novedu.validation.MaxLength;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Max Huang
 */
public class Bulletin {
    /**
     * 公告唯一id
     */

    private String id;
    /**
     * 班级id
     */
    @MaxLength(50)
    private String clazzId;
    /**
     * 公告标题
     */
    @NotNull
    @MaxLength(50)
    private String title;
    /**
     * 公告内容
     */
    @NotNull
    private String content;

    public Bulletin(String clazzId, String title, String content, Date createTime) {
        this.clazzId = clazzId;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public Bulletin() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 发布时间
     */
    private Date createTime;
}
