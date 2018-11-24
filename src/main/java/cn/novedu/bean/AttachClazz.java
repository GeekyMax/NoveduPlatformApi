package cn.novedu.bean;

/**
 * 学生参与课程
 * @author Max Huang
 */
public class AttachClazz {
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
}
