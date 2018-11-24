package cn.novedu.result;

import cn.novedu.bean.Clazz;
import cn.novedu.constant.UserType;

import java.util.List;

public class ClassesResult {
    private Object user;
    private List<Clazz> classList;
    private UserType userType;

    public ClassesResult(Object user, List<Clazz> classList, UserType userType) {
        this.user = user;
        this.classList = classList;
        this.userType = userType;
    }

    public ClassesResult(Object user, List<Clazz> classList) {
        this.user = user;
        this.classList = classList;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public List<Clazz> getClassList() {
        return classList;
    }

    public void setClassList(List<Clazz> classList) {
        this.classList = classList;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
