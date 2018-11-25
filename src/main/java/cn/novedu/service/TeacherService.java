package cn.novedu.service;

import java.util.List;

import cn.novedu.bean.TeacherInfo;
import cn.novedu.bean.User;
import cn.novedu.constant.Sex;
import cn.novedu.constant.UserType;
import cn.novedu.jdbc.id.IdGenerator;
import cn.novedu.mapper.TeacherInfoMapper;
import cn.novedu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherService {
    @Autowired
    TeacherInfoMapper teacherInfoMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    IdGenerator idGenerator;

    public TeacherInfo findById(String id) {
        return teacherInfoMapper.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public String insertTeacher(String username, String name, String password) {
        User user = new User(username, name, password, UserType.TEACHER);
        int userInsertResult = userMapper.insert(user);
        TeacherInfo teacherInfo = new TeacherInfo(user.getId(), username, name);
        int teacherInfoInsertResult = teacherInfoMapper.insertSelective(teacherInfo);
        if (userInsertResult != 1 || teacherInfoInsertResult != 1) {
            throw new RuntimeException();
        }
        return user.getId();
    }


}
