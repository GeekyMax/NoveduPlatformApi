package cn.novedu.bean;

public class HomeworkSetting {
    /**
     * 作业id
     */
    private String homeworkId;
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

    public HomeworkSetting() {
    }

    public HomeworkSetting(Boolean coverable, Boolean overdueable, Boolean personal, Boolean allowTeamMemberSubmit) {
        this.coverable = coverable;
        this.overdueable = overdueable;
        this.personal = personal;
        this.allowTeamMemberSubmit = allowTeamMemberSubmit;
    }

    public String getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
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
