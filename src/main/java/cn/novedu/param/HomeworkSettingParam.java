package cn.novedu.param;

import cn.novedu.util.DateJsonDeserializer;
import cn.novedu.util.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class HomeworkSettingParam {
    /**
     * 修改标题
     */
    private String title;
    /**
     * 修改内容
     */
    private String content;
    /**
     * 修改通知
     */
    private String notice;
    /**
     * 修改启用时间
     */
    @JsonSerialize(using = DateJsonSerializer.class)
    @JsonDeserialize(using = DateJsonDeserializer.class)
    private Date activeTime;
    /**
     * 修改截止时间
     */
    @JsonSerialize(using = DateJsonSerializer.class)
    @JsonDeserialize(using = DateJsonDeserializer.class)
    private Date deadline;
    /**
     * 是否可覆盖
     */
    private Boolean coverable;
    /**
     * 是否可逾期提交
     */
    private Boolean overdueable;
    /**
     * 是否属于个人作业(非个人即小组作业)
     */
    private Boolean personal;
    /**
     * 允许组员提交
     */
    private Boolean allowTeamMemberSubmit;

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

    public Boolean getCoverable() {
        return coverable;
    }

    public void setCoverable(Boolean coverable) {
        this.coverable = coverable;
    }

    public Boolean getOverdueable() {
        return overdueable;
    }

    public void setOverdueable(Boolean overdueable) {
        this.overdueable = overdueable;
    }

    public Boolean getPersonal() {
        return personal;
    }

    public void setPersonal(Boolean personal) {
        this.personal = personal;
    }

    public Boolean getAllowTeamMemberSubmit() {
        return allowTeamMemberSubmit;
    }

    public void setAllowTeamMemberSubmit(Boolean allowTeamMemberSubmit) {
        this.allowTeamMemberSubmit = allowTeamMemberSubmit;
    }
}
