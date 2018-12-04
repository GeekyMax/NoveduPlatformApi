package cn.novedu.controller;

import cn.novedu.bean.Response;
import cn.novedu.bean.StudentInfo;
import cn.novedu.bean.TeacherInfo;
import cn.novedu.bean.User;
import cn.novedu.constant.UserType;
import cn.novedu.mapper.StudentInfoMapper;
import cn.novedu.param.StudentParam;
import cn.novedu.security.PermissionException;
import cn.novedu.service.StudentService;
import cn.novedu.service.TeacherService;
import cn.novedu.util.StringUtil;
import cn.novedu.param.LoginParam;
import cn.novedu.security.IgnoreSecurity;
import cn.novedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


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

    @RequestMapping(value = "users", method = {RequestMethod.GET})
    public Response users(@RequestHeader("X-NOV-TOKEN") String token) throws Exception {
        String id = userService.getUserId(token);
        UserType userType = userService.findUserTypeById(id);
        if (userType == UserType.STUDENT) {
            StudentInfo studentInfo = studentService.findById(id);
            return new Response().success(studentInfo);
        } else if (userType == UserType.TEACHER) {
            TeacherInfo teacherInfo = teacherService.findById(id);
            return new Response().success(teacherInfo);
        }
        return new Response().failure();
    }

    /**
     * 上传csv文件批量添加学生
     * @param token
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "students/files", method = RequestMethod.POST)
    public Response postUsersWithFile(@RequestHeader("X-NOV-TOKEN") String token, @RequestParam("file") MultipartFile file) throws Exception {
        //todo 最好对内容进行检查
        if (!userService.checkAdmin(token)) {
            throw new PermissionException();
        }
        if (file == null) {
            return new Response().failure("need file field");
        }
        List<Integer> resultList = new ArrayList<>();
        int index = 1;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(),"UTF-8"));
        String line = bufferedReader.readLine();
        while (line != null && !"".equals(line)) {
            Boolean result = false;
            try {
                result = userService.insertStudent(line);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (result) {
                resultList.add(index);
            }
            index++;
            line = bufferedReader.readLine();
        }
        return new Response().success(resultList);
    }

    /**
     * 添加单个学生信息
     * @param token
     * @param studentParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "students", method = RequestMethod.POST)
    public Response postUsers(@RequestHeader("X-NOV-TOKEN") String token, @Valid @RequestBody StudentParam studentParam) throws Exception {
        if (!userService.checkAdmin(token)) {
            throw new PermissionException();
        }
        if (userService.insertStudent(studentParam)) {
            return new Response().success();
        } else {
            return new Response().failure();
        }
    }
}
