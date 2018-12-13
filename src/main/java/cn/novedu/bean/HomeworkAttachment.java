package cn.novedu.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Max Huang
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class HomeworkAttachment {
    /**
     * 附件唯一id
     */
    private String id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 文件信息
     */
    private FileInfo fileInfo;
    /**
     * 所属homeworkId
     */
    private String homeworkId;

    public HomeworkAttachment() {
    }

    public HomeworkAttachment(String userId, FileInfo fileInfo) {
        this.userId = userId;
        this.fileInfo = fileInfo;
    }

    public String getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }
}
