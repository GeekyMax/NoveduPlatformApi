package cn.novedu.controller;

import cn.novedu.bean.Clazz;
import cn.novedu.bean.Response;
import cn.novedu.bean.StudentInfo;
import cn.novedu.bean.TeacherInfo;
import cn.novedu.constant.Constant;
import cn.novedu.constant.UserType;
import cn.novedu.jdbc.paging.PagingManager;
import cn.novedu.param.PagingParam;
import cn.novedu.result.ClassesResult;
import cn.novedu.security.PermissionException;
import cn.novedu.service.ClazzService;
import cn.novedu.service.StudentService;
import cn.novedu.service.TeacherService;
import cn.novedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Max Huang
 */
@RestController
public class ClazzController {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private PagingManager pagingManager;

    @RequestMapping(value = "classes", method = RequestMethod.GET)
    public Response classes(
            @RequestHeader(Constant.TOKEN_NAME) String token,
            @RequestParam(value = "page", defaultValue = "0") int pageNum,
            @RequestParam(value = "per_page", defaultValue = "0") int pageSize,
            @RequestParam(value = "order", defaultValue = "asc") String order,
            @RequestParam(value = "sort", defaultValue = "name") String sort) {
        String userId = userService.getUserId(token);
        String orderBy = pagingManager.handleOrderBy("post", sort, order);
        if (orderBy == null) {
            orderBy = "name asc";
        }
        PagingParam pagingParam = new PagingParam(pageNum, pageSize, orderBy);
        UserType userType = userService.findUserTypeById(userId);
        if (userType == UserType.STUDENT) {
            StudentInfo studentInfo = studentService.findById(userId);
            List<Clazz> clazzList = clazzService.findByStudentId(userId, pagingParam);
            return new Response().success(new ClassesResult(studentInfo, clazzList, userType));
        } else if (userType == UserType.TEACHER) {
            TeacherInfo teacherInfo = teacherService.findById(userId);
            List<Clazz> clazzList = clazzService.findByTeacherId(userId, pagingParam);
            return new Response().success(new ClassesResult(teacherInfo, clazzList, userType));
        } else {
            return new Response().failure("unknown type");
        }
    }

    @RequestMapping(value = "classes/{id}", method = RequestMethod.GET)
    public Response classes(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("id") String clazzId) {
        String userId = userService.getUserId(token);
        UserType userType = userService.findUserTypeById(userId);
        List<Clazz> clazzList = new ArrayList<>();
        if (userType == UserType.STUDENT) {
            StudentInfo studentInfo = studentService.findById(userId);
            Clazz clazz = clazzService.findByClazzIdAndStudentId(clazzId, userId);
            if (clazz != null) {
                clazzList.add(clazz);
                return new Response().success(new ClassesResult(studentInfo, clazzList, userType));
            }
        } else if (userType == UserType.TEACHER) {
            TeacherInfo teacherInfo = teacherService.findById(userId);
            Clazz clazz = clazzService.findByClazzIdAndTeacherId(clazzId, userId);
            if (clazz != null) {
                clazzList.add(clazz);
                return new Response().success(new ClassesResult(teacherInfo, clazzList, userType));
            }
        } else {
            throw new PermissionException("permission denied");
        }
        return new Response().failure();
    }
}
