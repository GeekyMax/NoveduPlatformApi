package cn.novedu.bean;

import cn.novedu.constant.ResourceType;

/**
 * @author Max Huang
 */
public class FileInfo {
    /**
     * 唯一编号
     */
    private String id;
    /**
     * 文件名(不唯一
     */
    private String name;
    /**
     * 文件类型
     */
    private ResourceType type;
    /**
     * 文件后缀名
     */
    private String fix;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 文件所在路径
     */
    private String path;
    /**
     * 上传用户id
     */
    private String userId;
    /**
     * 备注
     */
    private String remark;
    /**
     * 其他信息
     */
    private String other;

    public FileInfo(String id, String name, ResourceType type, String fix, long size, String path, String userId, String remark, String other) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.fix = fix;
        this.size = size;
        this.path = path;
        this.userId = userId;
        this.remark = remark;
        this.other = other;
    }

    public FileInfo() {
    }

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

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
