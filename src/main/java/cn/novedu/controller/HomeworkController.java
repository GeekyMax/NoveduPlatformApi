package cn.novedu.controller;

import cn.novedu.bean.Homework;
import cn.novedu.bean.HomeworkSetting;
import cn.novedu.bean.Response;
import cn.novedu.constant.Constant;
import cn.novedu.constant.HomeworkState;
import cn.novedu.param.HomeworkSettingParam;
import cn.novedu.security.IgnoreSecurity;
import cn.novedu.service.HomeworkService;
import cn.novedu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author Max Huang
 */
@RestController
public class HomeworkController {
    @Autowired
    private UserService userService;
    @Autowired
    private HomeworkService homeworkService;
    private Logger logger = LoggerFactory.getLogger(HomeworkController.class);

    /**
     * 获取该课程的作业列表
     * 如果是学生返回所有已经启用的作业
     * 如果是教师返回所有状态的作业
     *
     * @param token   用户凭证
     * @param clazzId 班级id
     * @return 所有可见的作业列表
     */
    @RequestMapping(value = "/classes/{id}/homework", method = RequestMethod.GET)
    public Response getHomework(
            @RequestHeader(Constant.TOKEN_NAME) String token,
            @PathVariable("id") String clazzId) {
        String userId = userService.getUserId(token);
        List<Homework> homeworkList = homeworkService.getHomework(userId, clazzId);
        if (homeworkList == null) {
            return new Response().failure();
        }
        return new Response().success(homeworkList);
    }

    /**
     * 添加一个作业.
     * 需要指定如下的一系列参数,部分可为空,
     * 每个作业可附带零到多个文件.<br/>
     * 可以在创建的时候指定启用时间和截止时间,
     * 也可以之后设置.
     *
     * @param token                 用户凭证
     * @param clazzId               所在班级
     * @param title                 作业大标题
     * @param content               作业详细内容
     * @param notice                作业提醒
     * @param multipartFiles        作业所带附件
     * @param activeTime            启用时间(可留空)
     * @param deadline              截止时间(可留空)
     * @param coverable             是否可覆盖(默认true)
     * @param overdueable           是否可逾期提交(默认false)
     * @param personal              是否是个人作业(默认true)
     * @param allowTeamMemberSubmit 是否允许组员提交(默认true)
     * @return 返回成功添加的作业信息
     * @throws Exception 插入文件时的异常
     */
    @IgnoreSecurity
    @RequestMapping(value = "/classes/{id}/homework", method = RequestMethod.POST)
    public Response postHomework(
            @RequestHeader(Constant.TOKEN_NAME) String token,
            @PathVariable("id") String clazzId,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("notice") String notice,
            @RequestParam("files") List<MultipartFile> multipartFiles,
            @RequestParam(value = "activeTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date activeTime,
            @RequestParam(value = "deadline", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date deadline,
            @RequestParam(value = "coverable", defaultValue = "true") Boolean coverable,
            @RequestParam(value = "overdueable", defaultValue = "false") Boolean overdueable,
            @RequestParam(value = "personal", defaultValue = "true") Boolean personal,
            @RequestParam(value = "allowTeamMemberSubmit", defaultValue = "true") Boolean allowTeamMemberSubmit,
            @RequestParam(value = "homeworkState", defaultValue = "NOT_SET") HomeworkState homeworkState
    ) throws Exception {
        String userId = userService.getUserId(token);
        HomeworkSetting homeworkSetting = new HomeworkSetting(coverable, overdueable, personal, allowTeamMemberSubmit);
        Homework homework = new Homework(clazzId, title, content, notice, null, homeworkState, new Date(), activeTime, deadline, homeworkSetting);
        homework = homeworkService.postHomework(userId, clazzId, homework, multipartFiles);
        return new Response().success(homework);
    }

    /**
     * @param token      用户凭证
     * @param homeworkId 作业编号
     * @param homework   作业设置参数
     * @return 修改后的作业信息
     */
    @RequestMapping(value = "/homework/{id}", method = RequestMethod.POST)
    public Response updateHomework(
            @RequestHeader(Constant.TOKEN_NAME) String token,
            @PathVariable("id") String homeworkId,
            @Valid @RequestBody Homework homework) {
        String userId = userService.getUserId(token);
        homework = homeworkService.updateHomeworkSetting(userId, homeworkId, homework);
        return new Response().success(homework);
    }
}
