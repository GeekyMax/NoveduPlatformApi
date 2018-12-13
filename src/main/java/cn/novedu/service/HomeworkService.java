package cn.novedu.service;

import cn.novedu.bean.*;
import cn.novedu.constant.HomeworkState;
import cn.novedu.constant.UserType;
import cn.novedu.mapper.*;
import cn.novedu.param.HomeworkSettingParam;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HomeworkService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AttendClazzMapper attendClazzMapper;
    @Autowired
    private TeachClazzMapper teachClazzMapper;
    @Autowired
    private HomeworkMapper homeworkMapper;
    @Autowired
    private HomeworkAttachmentMapper homeworkAttachmentMapper;
    @Autowired
    private HomeworkSettingMapper homeworkSettingMapper;
    @Autowired
    private FileService fileService;
    @Autowired
    private FileInfoMapper fileInfoMapper;

    public List<Homework> getHomework(String userId, String clazzId) {
        UserType userType = userMapper.findUserTypeById(userId);
        List<Homework> homeworkList = new ArrayList<>();
        if (userType == UserType.TEACHER) {
            Assert.assertTrue(teachClazzMapper.judgeTeacherInClazz(userId, clazzId));
            homeworkList = homeworkMapper.findByClazzId(clazzId);
        } else if (userType == UserType.STUDENT) {
            Assert.assertTrue(attendClazzMapper.judgeStudentInClazz(userId, clazzId));
            homeworkList = homeworkMapper.findByClazzIdAndHomeworkState(clazzId, HomeworkState.ACTIVE);
        }
        return homeworkList;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public Homework postHomework(String userId, String clazzId, Homework homework, List<MultipartFile> multipartFileList) throws Exception {
        Assert.assertTrue(teachClazzMapper.judgeTeacherInClazz(userId, clazzId));
        Assert.assertTrue(homework.checkValid());
        homeworkMapper.insertSelective(homework);
        HomeworkSetting homeworkSetting = homework.getHomeworkSetting();
        Assert.assertNotNull(homework.getId());
        homeworkSetting.setHomeworkId(homework.getId());
        int result = homeworkSettingMapper.insertSelective(homeworkSetting);
        Assert.assertEquals(result, 1);
        List<HomeworkAttachment> homeworkAttachments = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFileList) {
            HomeworkAttachment homeworkAttachment = fileService.uploadHomeworkAttachment(multipartFile, userId);
            Assert.assertNotNull(homeworkAttachment);
            fileInfoMapper.insert(homeworkAttachment.getFileInfo());
            homeworkAttachment.setHomeworkId(homework.getId());
            homeworkAttachmentMapper.insert(homeworkAttachment);
            homeworkAttachments.add(homeworkAttachment);
        }
        homework.setAttachmentList(homeworkAttachments);
        return homework;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public Homework updateHomeworkSetting(String userId, String homeworkId, Homework homework) {
        homework.setId(homeworkId);
        Homework homework1 = homeworkMapper.findById(homework.getId());
        Assert.assertTrue(teachClazzMapper.judgeTeacherInClazz(userId, homework1.getClazzId()));
        int result = homeworkMapper.updateByPrimaryKeySelective(homework);
        Assert.assertEquals(1, result);
        result = homeworkSettingMapper.updateByPrimaryKeySelective(homework.getHomeworkSetting());
        Assert.assertEquals(1, result);
        return homeworkMapper.findById(homeworkId);
    }
}
