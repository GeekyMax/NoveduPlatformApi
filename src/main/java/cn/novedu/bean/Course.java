package cn.novedu.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 课程实体类
 * @author Max Huang
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Course {
    /**
     * 课程唯一id
     */
    private String id;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 课程教材
     */
    private String textbook;
    /**
     * 课程代码
     */
    private String code;
    /**
     * 课程种类
     */
    private String type;
    /**
     * 课程学年
     */
    private String year;
    /**
     * 课程学期
     */
    private String semester;
    /**
     * 课程英文名
     */
    private String englishName;
    /**
     * 开课学院
     */
    private String college;
    /**
     * 课程学分
     */
    private Double credit;
    /**
     * 周学时
     */
    private Integer weekLearningTime;
    /**
     * 权重
     */
    private String weight;
    /**
     * 预修课程
     */
    private String preLearning;
    /**
     * 教学计划
     */
    private String plan;
    /**
     * 课程背景
     */
    private String background;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextbook() {
        return textbook;
    }

    public void setTextbook(String textbook) {
        this.textbook = textbook;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Integer getWeekLearningTime() {
        return weekLearningTime;
    }

    public void setWeekLearningTime(Integer weekLearningTime) {
        this.weekLearningTime = weekLearningTime;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPreLearning() {
        return preLearning;
    }

    public void setPreLearning(String preLearning) {
        this.preLearning = preLearning;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
