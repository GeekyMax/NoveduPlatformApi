package cn.novedu.service;

import java.util.List;

import cn.novedu.bean.*;
import cn.novedu.jdbc.id.IdGenerator;
import cn.novedu.mapper.*;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private ClazzSettingMapper clazzSettingMapper;
    @Autowired
    private ClazzEnvironmentMapper clazzEnvironmentMapper;
    @Autowired
    private TeachClazzMapper teachClazzMapper;
    @Autowired
    private TeacherInfoMapper teacherInfoMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    IdGenerator idGenerator;
    Logger logger = LoggerFactory.getLogger(ClazzService.class);

    public List<Clazz> find() {
        return clazzMapper.find();
    }

    public List<Clazz> findByStudentId(String studentId) {
        return clazzMapper.findByStudentId(studentId);
    }

    public List<Clazz> findByTeacherId(String teacherId) {
        return clazzMapper.findByTeacherId(teacherId);
    }

    public Clazz findByClazzIdAndStudentId(String clazzId, String studentId) {
//        Integer count = attendClazzMapper.countByStudentIdAndClazzId(studentId, clazzId);
//        if (count != null && count > 0) {
//            return clazzMapper.findById(clazzId);
//        } else {
//            return null;
//        }
        return clazzMapper.findByClazzIdAndStudentId(clazzId, studentId);
    }

    public Clazz findByClazzIdAndTeacherId(String clazzId, String teacherId) {
//        Integer count = teachClazzMapper.countByTeacherIdAndClazzId(teacherId, clazzId);
//        if (count != null && count > 0) {
//            return clazzMapper.findById(clazzId);
//        } else {
//            return null;
//        }
        return clazzMapper.findByClazzIdAndTeacherId(clazzId, teacherId);
    }

    /**
     * 插入班级,若出现错误会进行事务会滚
     *
     * @param clazz
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public void insert(Clazz clazz) {
        /*
         * 如果course为空.抛出异常
         */
        if (clazz.getCourse() == null) {
            logger.error("course can't be empty");
            throw new RuntimeException();
        }
        /*
         * 如果course id为空,那么就试试用code找到course
         */
        if (clazz.getCourse().getId() == null) {
            if (clazz.getCourse().getCode() != null) {
                Course course = courseMapper.findByCode(clazz.getCourse().getCode());
                if (course == null) {
                    throw new RuntimeException();
                }
                clazz.setCourse(course);
            } else {
                throw new RuntimeException();
            }
        }
        /*
         * 插入clazz表
         */
        int clazzInsertResult = clazzMapper.insertSelective(clazz);
        if (clazzInsertResult != 1) {
            throw new RuntimeException();
        }
        String clazzId = clazz.getId();
        /*
         * 处理clazzSetting
         */
        ClazzSetting clazzSetting = clazz.getClazzSetting();
        clazzSetting.setClazzId(clazzId);
        int clazzSettingInsertResult = clazzSettingMapper.insertSelective(clazzSetting);
        if (clazzSettingInsertResult != 1) {
            throw new RuntimeException();
        }
        /*
         * 插入clazzEnvironment
         */
        List<ClazzEnvironment> clazzEnvironmentList = clazz.getClazzEnvironments();
        for (ClazzEnvironment clazzEnvironment : clazzEnvironmentList) {
            clazzEnvironment.setClazzId(clazzId);
            int clazzEnvironmentInsertResult = clazzEnvironmentMapper.insertSelective(clazzEnvironment);
            if (clazzEnvironmentInsertResult != 1) {
                throw new RuntimeException();
            }
        }
        for (TeacherInfo teacherInfo : clazz.getTeachers()) {
            /*
             * 如果没有没有教师id,那就试试教工号
             */
            if (teacherInfo.getId() == null) {
                if (teacherInfo.getUsername() != null) {
                    teacherInfo = teacherInfoMapper.findByUsername(teacherInfo.getUsername());
                    if (teacherInfo == null) {
                        throw new RuntimeException();
                    }
                } else {
                    throw new RuntimeException();
                }
            }

            TeachClazz teachClazz = new TeachClazz(teacherInfo.getId(), clazzId);
            int teachClazzInsertResult = teachClazzMapper.insert(teachClazz);
            if (teachClazzInsertResult != 1) {
                throw new RuntimeException();
            }
        }
    }
}
