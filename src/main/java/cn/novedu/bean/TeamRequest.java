package cn.novedu.bean;

import cn.novedu.constant.TeamRequestState;

import java.util.Date;

/**
 * @author Max Huang
 */
public class TeamRequest {
    /**
     * 请求唯一id
     */
    private String id;
    /**
     * 学生id
     */
    private String studentId;
    /**
     * 队伍id
     */
    private String teamId;
    /**
     * 请求状态
     */
    private TeamRequestState teamRequestState;
    /**
     * 请求发起时间
     */
    private Date createTime;
    /**
     * 请求处理时间
     */
    private Date handleTime;

    public TeamRequest(String studentId, String teamId) {
        this.studentId = studentId;
        this.teamId = teamId;
    }

    public TeamRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public TeamRequestState getTeamRequestState() {
        return teamRequestState;
    }

    public void setTeamRequestState(TeamRequestState teamRequestState) {
        this.teamRequestState = teamRequestState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }
}
