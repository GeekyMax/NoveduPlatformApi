package cn.novedu.param;

import cn.novedu.constant.Sex;

import javax.validation.constraints.NotNull;

public class StudentParam {
    /**
     * 学生学号
     */
    @NotNull
    private String username;
    /**
     * 学生姓名
     */
    @NotNull
    private String name;
    /**
     * 学生密码
     */
    @NotNull
    private String password;
    /**
     * 学生性别
     */
    @NotNull
    private Sex sex;
    /**
     * 学生学院
     */
    @NotNull
    private String college;
    /**
     * 学生专业
     */
    @NotNull
    private String major;
    /**
     * 学生年级
     */
    @NotNull
    private String grade;
    /**
     * 学生班级
     */
    @NotNull
    private String clazz;
    /**
     * 学生电话
     */
    private String phone;
    /**
     * 学生邮箱
     */
    private String email;

    public StudentParam() {
    }

    public StudentParam(@NotNull String username, @NotNull String name, @NotNull String password, @NotNull Sex sex, @NotNull String college, @NotNull String major, @NotNull String grade, @NotNull String clazz, String phone, String email) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.college = college;
        this.major = major;
        this.grade = grade;
        this.clazz = clazz;
        this.phone = phone;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
