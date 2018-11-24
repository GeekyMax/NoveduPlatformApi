package cn.novedu.bean;

import cn.novedu.constant.Sex;

public class TeacherInfo {
    /**
     * 教师唯一id
     */
    private String id;
    /**
     * 教师卡号
     */
    private String username;
    /**
     * 教师姓名
     */
    private String name;
    /**
     * 教师性别 默认男
     */
    private Sex sex;
    /**
     * 教师所属学院
     */
    private String college;
    /**
     * 教师所属系
     */
    private String department;
    /**
     * 教师职位
     */
    private String position;
    /**
     * 教师学历
     */
    private String education;
    /**
     * 教师以往教学评价
     */
    private String pastEvaluation;
    /**
     * 教学风格
     */
    private String teachStyle;
    /**
     * 出版作品
     */
    private String publish;
    /**
     * 教师所获荣誉
     */
    private String honor;
    /**
     * 更多信息
     */
    private String more;
    /**
     * 教师电话
     */
    private String phone;
    /**
     * 教师电子邮箱
     */
    private String email;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPastEvaluation() {
        return pastEvaluation;
    }

    public void setPastEvaluation(String pastEvaluation) {
        this.pastEvaluation = pastEvaluation;
    }

    public String getTeachStyle() {
        return teachStyle;
    }

    public void setTeachStyle(String teachStyle) {
        this.teachStyle = teachStyle;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
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
