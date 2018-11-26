package cn.novedu.bean;

/**
 * 学生参与课程
 *
 * @author Max Huang
 */
public class AttendClazz {
    /**
     * 唯一id
     */
    private String id;
    /**
     * 学生id
     */
    private String studentId;
    /**
     * 班级id
     */
    private String clazzId;
    /**
     * 所加入的队伍
     */
    private String teamId;

    public AttendClazz(String studentId, String clazzId) {
        this.studentId = studentId;
        this.clazzId = clazzId;
    }

    public AttendClazz() {
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

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
