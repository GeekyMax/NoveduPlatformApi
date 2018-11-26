package cn.novedu.bean;

import cn.novedu.constant.Sex;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Max Huang
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class StudentInfo {
    /**
     * 唯一id
     */
    private String id;
    /**
     * 学生学号
     */
    private String username;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 学生性别
     */
    private Sex sex;
    /**
     * 学生学院
     */
    private String college;
    /**
     * 学生专业
     */
    private String major;
    /**
     * 学生年级
     */
    private String grade;
    /**
     * 学生班级
     */
    private String clazz;
    /**
     * 学生电话
     */
    private String phone;
    /**
     * 学生邮箱
     */
    private String email;

    public StudentInfo(String id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public StudentInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
