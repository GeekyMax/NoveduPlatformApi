package cn.novedu.bean;

import cn.novedu.constant.HomeworkState;
import cn.novedu.validation.MaxLength;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author Max Huang
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Homework {
    /**
     * 作业唯一id
     */
    private String id;
    /**
     * 课程id
     */
    private String clazzId;
    /**
     * 标题
     */
    @NotNull
    @MaxLength(100)
    private String title;
    /**
     * 详细内容
     */
    @NotNull
    private String content;
    /**
     * 注意事项
     */
    @NotNull
    private String notice;
    /**
     * 附件列表
     */
    private List<HomeworkAttachment> attachmentList;
    /**
     * 作业状态
     */
    private HomeworkState homeworkState;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 启用时间
     */
    private Date activeTime;
    /**
     * 截止日期
     */
    private Date deadline;
    /**
     * 作业相关的设定
     */
    private HomeworkSetting homeworkSetting;

    public Homework(String clazzId, @NotNull String title, @NotNull String content, @NotNull String notice, List<HomeworkAttachment> attachmentList, HomeworkState homeworkState, Date createTime, Date activeTime, Date deadline, HomeworkSetting homeworkSetting) {
        this.clazzId = clazzId;
        this.title = title;
        this.content = content;
        this.notice = notice;
        this.attachmentList = attachmentList;
        this.homeworkState = homeworkState;
        this.createTime = createTime;
        this.activeTime = activeTime;
        this.deadline = deadline;
        this.homeworkSetting = homeworkSetting;
    }

    public Homework() {
    }

    public boolean checkValid() {
        if (title == null || title.length() > 100) {
            return false;
        }
        if (content == null || notice == null) {
            return false;
        }
        if (activeTime != null && deadline != null && deadline.before(activeTime)) {
            return false;
        }
        return true;
    }

    public HomeworkState getHomeworkState() {
        return homeworkState;
    }

    public void setHomeworkState(HomeworkState homeworkState) {
        this.homeworkState = homeworkState;
    }

    public HomeworkSetting getHomeworkSetting() {
        return homeworkSetting;
    }

    public void setHomeworkSetting(HomeworkSetting homeworkSetting) {
        this.homeworkSetting = homeworkSetting;
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

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public List<HomeworkAttachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<HomeworkAttachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
