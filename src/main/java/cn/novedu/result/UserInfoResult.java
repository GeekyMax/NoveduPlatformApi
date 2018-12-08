package cn.novedu.result;

import cn.novedu.constant.UserType;

import java.util.ArrayList;
import java.util.List;

public class UserInfoResult {
    List<String> roles;
    String avatar;
    Object userInfo;

    public UserInfoResult() {
    }

    public UserInfoResult(UserType userType) {
        this.roles =new ArrayList<>();
        roles.add(userType.toString());
        this.avatar = userType.toString();
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Object getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Object userInfo) {
        this.userInfo = userInfo;
    }
}