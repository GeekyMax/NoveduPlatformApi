package cn.novedu.bean;

/**
 * @author Max Huang
 */
public class UserInfo {
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户学工号
     */
    private String username;

    /**
     * 用户真实姓名
     */
    private String name;

    public UserInfo(String id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public UserInfo() {
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
}
