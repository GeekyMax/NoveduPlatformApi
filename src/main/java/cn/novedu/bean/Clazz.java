package cn.novedu.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author Max Huang
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Clazz {

    /**
     * 开课id
     */
    private String id;
    /**
     * 本课代码
     */
    private String code;
    /**
     * 所属课程
     */
    private Course course;
    /**
     * 授课教师
     */
    private List<TeacherInfo> teachers;
    /**
     * 上课时间地点
     */
    private List<ClazzEnvironment> clazzEnvironments;
    /**
     * 学生数量
     */
    private Integer studentCount;
    /**
     * 班级的一些设置
     */
    private ClazzSetting clazzSetting;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<TeacherInfo> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherInfo> teachers) {
        this.teachers = teachers;
    }

    public List<ClazzEnvironment> getClazzEnvironments() {
        return clazzEnvironments;
    }

    public void setClazzEnvironments(List<ClazzEnvironment> clazzEnvironments) {
        this.clazzEnvironments = clazzEnvironments;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public ClazzSetting getClazzSetting() {
        return clazzSetting;
    }

    public void setClazzSetting(ClazzSetting clazzSetting) {
        this.clazzSetting = clazzSetting;
    }
}
