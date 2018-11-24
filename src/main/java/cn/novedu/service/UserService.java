package cn.novedu.service;
import java.util.List;

import cn.novedu.bean.User;
import cn.novedu.constant.UserType;
import cn.novedu.jdbc.id.IdGenerator;
import cn.novedu.mapper.UserMapper;
import cn.novedu.security.TokenManager;
import cn.novedu.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Max Huang
 */
@Service
public class UserService {
    @Autowired
    IdGenerator idGenerator;
    @Autowired
    UserMapper userMapper;
    @Autowired
    TokenManager tokenManager;
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    /**
     * 用户登录, 登陆成功返回token,登录失败返回null
     *
     * @param username
     * @param password
     * @return
     */
    public String login(String username, String password) {
        try {
            User user = userMapper.findByUsername(username);
            if (StringUtil.isNotEmpty(password) && password.equals(user.getPassword())) {
                return tokenManager.createToken(user.getId());
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * 用户注册,成功返回用户id,失败返回null
     *
     * @param name
     * @param password
     * @return
     * @Param username
     */
    public String signup(String username, String name, String password, UserType userType) {
        try {
            String id = idGenerator.generateId();
            logger.debug("generated id is: " + id);
            User user = new User(id, username, name, password, userType);
            int result = userMapper.insert(user);
            if (result != 1) {
                return null;
            }
            return user.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUserId(String token) {
        return tokenManager.getUserId(token);
    }

	public UserType findUserTypeById(String id){
		 return userMapper.findUserTypeById(id);
	}
}
