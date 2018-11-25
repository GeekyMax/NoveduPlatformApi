package cn.novedu.bean;

import cn.novedu.constant.UserType;

/**
 * @author Max Huang
 */
public class User {
    private String id;
    private String username;
    private String name;
    private String password;
    private UserType userType;

    public User(String username, String name, String password, UserType userType) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.userType = userType;
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
