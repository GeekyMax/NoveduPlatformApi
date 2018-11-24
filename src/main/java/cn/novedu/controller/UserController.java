package cn.novedu.controller;

import cn.novedu.bean.Response;
import cn.novedu.bean.StudentInfo;
import cn.novedu.bean.TeacherInfo;
import cn.novedu.constant.UserType;
import cn.novedu.mapper.StudentInfoMapper;
import cn.novedu.service.StudentService;
import cn.novedu.service.TeacherService;
import cn.novedu.util.StringUtil;
import cn.novedu.param.LoginParam;
import cn.novedu.security.IgnoreSecurity;
import cn.novedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Max Huang
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @IgnoreSecurity
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Response login(
            @Valid @RequestBody LoginParam loginParam
    ) {
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        String token = userService.login(username, password);
        if (StringUtil.isNotEmpty(token)) {
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            return new Response().success(map);
        } else {
            return new Response().failure("error username or password");
        }
    }

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public Response welcome() {
        return new Response().success("welcome");
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public Response users(@RequestHeader("X-NOV-TOKEN") String token) throws Exception {
        String id = userService.getUserId(token);
        if (userService.findUserTypeById(id) == UserType.STUDENT) {
            StudentInfo studentInfo = studentService.findById(id);
            return new Response().success(studentInfo);
        } else if (userService.findUserTypeById(id) == UserType.TEACHER) {
            TeacherInfo teacherInfo = teacherService.findById(id);
            return new Response().success(teacherInfo);
        }
        return new Response().failure();
    }
}

