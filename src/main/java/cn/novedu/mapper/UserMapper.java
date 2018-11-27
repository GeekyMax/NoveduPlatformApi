package cn.novedu.mapper;

import cn.novedu.bean.UserInfo;
import cn.novedu.constant.UserType;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.novedu.bean.User;

@Mapper
public interface UserMapper {
    int insert(@Param("user") User user);

    int insertSelective(@Param("user") User user);

    int insertList(@Param("users") List<User> users);

    int updateByPrimaryKeySelective(@Param("user") User user);

    User findByUsername(@Param("username") String username);

    UserType findUserTypeById(@Param("id") String id);

    UserInfo findUserInfoById(String id);
}
