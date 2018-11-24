package cn.novedu.bean;

public class TeachClazz {
    /**
     * 唯一id
     */
    private String id;
    /**
     * 教师id
     */
    private String teacherId;
    /**
     * 上课id
     */
    private String clazzId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }
}
