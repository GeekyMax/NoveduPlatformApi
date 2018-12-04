package cn.novedu.service;

import cn.novedu.bean.StudentInfo;
import cn.novedu.bean.User;
import cn.novedu.constant.Sex;
import cn.novedu.constant.UserType;
import cn.novedu.jdbc.id.IdGenerator;
import cn.novedu.mapper.StudentInfoMapper;
import cn.novedu.mapper.UserMapper;
import cn.novedu.param.StudentParam;
import cn.novedu.security.TokenManager;
import cn.novedu.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    StudentInfoMapper studentInfoMapper;
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
            User user = new User(username, name, password, userType);
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

    public UserType findUserTypeById(String id) {
        return userMapper.findUserTypeById(id);
    }

    public boolean checkAdmin(String token) {
        String id = getUserId(token);
        UserType userType = findUserTypeById(id);
        if (userType != UserType.ADMIN) {
            return false;
        }
        return true;
    }

    /**
     * 插入一个学生以 "username,name,password,userType,sex,college,major,grade,clazz,phone,email"的格式
     *
     * @param string
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public Boolean insertStudent(String string) {
        String[] params = string.split(",");
        String username = params[0];
        String name = params[1];
        String password = params[2];
        UserType userType = UserType.STUDENT;
        Sex sex;
        if ("MALE".equals(params[3])) {
            sex = Sex.MALE;
        } else if ("FEMALE".equals(params[3])) {
            sex = Sex.FEMALE;
        } else {
            throw new RuntimeException();
        }
        String college = params[4];
        String major = params[5];
        String grade = params[6];
        String clazz = params[7];
        String phone = params[8];
        String email = params[9];
        StudentParam studentParam = new StudentParam(
                username,
                name,
                password,
                sex,
                college,
                major,
                grade,
                clazz,
                phone,
                email
        );
        return insertStudent(studentParam);

    }

    /**
     * 以StudentParam为参数插入
     *
     * @param studentParam
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public Boolean insertStudent(StudentParam studentParam) {
        User user = new User(studentParam.getUsername(), studentParam.getName(), studentParam.getPassword(), UserType.STUDENT);
        if (userMapper.insert(user) != 1) {
            throw new RuntimeException();
        }
        StudentInfo studentInfo = new StudentInfo(
                user.getId(),
                studentParam.getUsername(),
                studentParam.getName(),
                studentParam.getSex(),
                studentParam.getCollege(),
                studentParam.getMajor(),
                studentParam.getGrade(),
                studentParam.getClazz(),
                studentParam.getPhone(),
                studentParam.getEmail()
        );
        if (studentInfoMapper.insert(studentInfo) != 1) {
            throw new RuntimeException();
        }
        return true;
    }

}