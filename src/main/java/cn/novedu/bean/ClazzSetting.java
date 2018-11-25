package cn.novedu.bean;

/**
 * @author Max Huang
 */
public class ClazzSetting {
    /**
     * 开课id
     */
    private String clazzId;
    /**
     * 是否允许组建小组
     */
    private Boolean teamAllowed;
    /**
     * 每小组人数上限
     */
    private Integer maxTeamMemberCount;
    /**
     * 小组数量上限
     */
    private Integer maxTeamCount;

    public ClazzSetting(String clazzId, Boolean teamAllowed, Integer maxTeamMemberCount, Integer maxTeamCount) {
        this.clazzId = clazzId;
        this.teamAllowed = teamAllowed;
        this.maxTeamMemberCount = maxTeamMemberCount;
        this.maxTeamCount = maxTeamCount;
    }

    public ClazzSetting(String clazzId) {
        this.clazzId = clazzId;
    }

    public ClazzSetting() {
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }

    public Boolean getTeamAllowed() {
        return teamAllowed;
    }

    public void setTeamAllowed(Boolean teamAllowed) {
        this.teamAllowed = teamAllowed;
    }

    public Integer getMaxTeamMemberCount() {
        return maxTeamMemberCount;
    }

    public void setMaxTeamMemberCount(Integer maxTeamMemberCount) {
        this.maxTeamMemberCount = maxTeamMemberCount;
    }

    public Integer getMaxTeamCount() {
        return maxTeamCount;
    }

    public void setMaxTeamCount(Integer maxTeamCount) {
        this.maxTeamCount = maxTeamCount;
    }
}
