package cn.novedu.bean;

import cn.novedu.validation.MaxLength;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;

/**
 * @author Max Huang
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Team {
    /**
     * 队伍 id
     */
    private String id;
    /**
     * 队伍名称
     */
    @NotNull
    private String name;
    /**
     * 队伍描述
     */
    @NotNull
    private String description;
    /**
     * 所属班级id
     */
    private String clazzId;
    /**
     * 队长
     */
    private StudentInfo leader;
    /**
     * 成员列表
     */
    private List<StudentInfo> memberList;
    /**
     * 成员数
     */
    private Integer memberNumber;
    /**
     * 创建时间
     */
    private Date createTime;

    public Team(String name, String description, String clazzId, StudentInfo leader) {
        this.name = name;
        this.description = description;
        this.clazzId = clazzId;
        this.leader = leader;
    }

    public Team() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }

    public StudentInfo getLeader() {
        return leader;
    }

    public void setLeader(StudentInfo leader) {
        this.leader = leader;
    }

    public List<StudentInfo> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<StudentInfo> memberList) {
        this.memberList = memberList;
    }

    public Integer getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(Integer memberNumber) {
        this.memberNumber = memberNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
