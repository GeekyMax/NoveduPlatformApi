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
    private Integer maxTeamNumberCount;

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

    public Integer getMaxTeamNumberCount() {
        return maxTeamNumberCount;
    }

    public void setMaxTeamNumberCount(Integer maxTeamNumberCount) {
        this.maxTeamNumberCount = maxTeamNumberCount;
    }
}
