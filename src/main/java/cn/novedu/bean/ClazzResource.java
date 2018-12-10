package cn.novedu.bean;

public class ClazzResource {
    /**
     * 课程资源唯一id
     */
    private String id;
    /**
     * 所属班级id
     */
    private String clazzId;
    /**
     * 展示的名字,不同于文件名
     */
    private String name;
    /**
     * 文件信息
     */
    private FileInfo fileInfo;
    /**
     * 是否可见
     */
    private Boolean visible;
    /**
     * 详细信息
     */
    private String detail;

    public ClazzResource(String clazzId, String name, FileInfo fileInfo, Boolean visible, String detail) {
        this.clazzId = clazzId;
        this.name = name;
        this.fileInfo = fileInfo;
        this.visible = visible;
        this.detail = detail;
    }

    public ClazzResource() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
