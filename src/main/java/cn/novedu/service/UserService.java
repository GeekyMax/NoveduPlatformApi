package cn.novedu.service;

import cn.novedu.bean.User;
import cn.novedu.security.TokenManager;
import cn.novedu.util.StringUtil;
import cn.novedu.mapper.UserMapper;
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
    UserMapper userMapper;
    @Autowired
    TokenManager tokenManager;
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    /**
     * 用户登录, 登陆成功返回token,登录失败返回null
     *
     * @param name
     * @param password
     * @return
     */
    public String login(String name, String password) {
        try {
            User user = userMapper.findByName(name);
            if (StringUtil.isNotEmpty(password) && password.equals(user.getPassword())) {
                return tokenManager.createToken(user.getId());
            }
            return null;
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return null;
        }
    }

    /**
     * 用户注册,成功返回用户id,失败返回null
     *
     * @param name
     * @param password
     * @return
     */
    public String signup(String name, String password) {
        try {
            User user = new User(name, password);
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
}
