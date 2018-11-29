package cn.novedu.service;

import java.util.ArrayList;
import java.util.List;

import cn.novedu.bean.*;
import cn.novedu.constant.UserType;
import cn.novedu.jdbc.id.IdGenerator;
import cn.novedu.mapper.*;
import cn.novedu.param.PagingParam;
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
    private AttendClazzMapper attendClazzMapper;
    @Autowired
    private TeacherInfoMapper teacherInfoMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    IdGenerator idGenerator;
    @Autowired
    private StudentInfoMapper studentInfoMapper;
    @Autowired
    private UserMapper userMapper;
    Logger logger = LoggerFactory.getLogger(ClazzService.class);

    public List<Clazz> find() {
        return clazzMapper.find();
    }

    public List<Clazz> findByStudentId(String studentId, PagingParam pagingParam) {
        return clazzMapper.findByStudentIdWithPaging(studentId, pagingParam.getPageNum(), pagingParam.getPageSize(), pagingParam.getOrderBy());
    }

    public List<Clazz> findByTeacherId(String teacherId, PagingParam pagingParam) {
        return clazzMapper.findByTeacherIdWithPaging(teacherId, pagingParam.getPageNum(), pagingParam.getPageSize(), pagingParam.getOrderBy());
    }

    public Clazz findByClazzIdAndStudentId(String clazzId, String studentId) {
        return clazzMapper.findByClazzIdAndStudentId(clazzId, studentId);
    }

    public Clazz findByClazzIdAndTeacherId(String clazzId, String teacherId) {
        return clazzMapper.findByClazzIdAndTeacherId(clazzId, teacherId);
    }

    public Clazz findByClazzIdAndUserId(String clazzId, String userId) {
        UserType userType = userMapper.findUserTypeById(userId);
        if (userType == null) {
            return null;
        } else if (userType == UserType.STUDENT) {
            return findByClazzIdAndStudentId(clazzId, userId);
        } else {
            return findByClazzIdAndTeacherId(clazzId, userId);
        }
    }

    /**
     * 插入班级,若出现错误会进行事务会滚
     *
     * @param clazz
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public void insert(Clazz clazz) {
        /*
         * 如果course为空.抛出异常
         */
        if (clazz.getCourse() == null) {
            logger.error("course can't be empty");
            throw new RuntimeException("course is empty");
        }
        /*
         * 如果course id为空,那么就试试用code找到course
         */
        if (clazz.getCourse().getId() == null) {
            if (clazz.getCourse().getCode() != null) {
                Course course = courseMapper.findByCode(clazz.getCourse().getCode());
                if (course == null) {
                    throw new RuntimeException("course can't be found");
                }
                clazz.setCourse(course);
            } else {
                throw new RuntimeException("course no id and code");
            }
        }
        /*
         * 插入clazz表
         */
        int clazzInsertResult = clazzMapper.insertSelective(clazz);
        if (clazzInsertResult != 1) {
            throw new RuntimeException("clazz insert fail");
        }
        String clazzId = clazz.getId();
        /*
         * 处理clazzSetting
         */
        ClazzSetting clazzSetting = clazz.getClazzSetting();
        if (clazzSetting == null) {
            throw new RuntimeException("clazzSetting is empty");
        }
        clazzSetting.setClazzId(clazzId);
        int clazzSettingInsertResult = clazzSettingMapper.insertSelective(clazzSetting);
        if (clazzSettingInsertResult != 1) {
            throw new RuntimeException("clazzSetting insert fail");
        }
        /*
         * 插入clazzEnvironment
         */
        List<ClazzEnvironment> clazzEnvironmentList = clazz.getClazzEnvironments();
        if (clazzEnvironmentList != null) {
            for (ClazzEnvironment clazzEnvironment : clazzEnvironmentList) {
                clazzEnvironment.setClazzId(clazzId);
                int clazzEnvironmentInsertResult = clazzEnvironmentMapper.insertSelective(clazzEnvironment);
                if (clazzEnvironmentInsertResult != 1) {
                    throw new RuntimeException("clazz Environment insert fail");
                }
            }
        }
        if (clazz.getTeachers() != null) {
            for (TeacherInfo teacherInfo : clazz.getTeachers()) {
                /*
                 * 如果没有没有教师id,那就试试教工号
                 */
                if (teacherInfo.getId() == null) {
                    if (teacherInfo.getUsername() != null) {
                        teacherInfo = teacherInfoMapper.findByUsername(teacherInfo.getUsername());
                        if (teacherInfo == null) {
                            throw new RuntimeException("teacherInfo can't be found");
                        }
                    } else {
                        throw new RuntimeException("teacherInfo no id and username");
                    }
                }
                TeachClazz teachClazz = new TeachClazz(teacherInfo.getId(), clazzId);
                int teachClazzInsertResult = teachClazzMapper.insert(teachClazz);
                if (teachClazzInsertResult != 1) {
                    throw new RuntimeException("teachClazz insert fail");
                }
            }

        }
    }

    /**
     * 批量添加参与班级的学生
     *
     * @param studentList StudentInfo list
     * @param clazzId     要插入的班级 id
     * @return 成功插入的学生id
     */
    public List<String> importClazzStudents(List<StudentInfo> studentList, String clazzId) {
        Integer clazzResult = clazzMapper.countById(clazzId);
        List<String> list = new ArrayList<>();
        if (studentList == null || clazzResult != 1) {
            return list;
        }
        for (StudentInfo studentInfo : studentList) {
            try {
                /*
                 * 如果没有id那就用username找一下
                 */
                if (studentInfo.getId() == null) {
                    if (studentInfo.getUsername() != null) {
                        StudentInfo newStudentInfo = studentInfoMapper.findByUsername(studentInfo.getUsername());
                        if (newStudentInfo != null) {
                            studentInfo = newStudentInfo;
                        }
                    }
                }
                if (studentInfo.getId() == null) {
                    continue;
                }
                int attendClazzInsertResult = attendClazzMapper.insertSelective(new AttendClazz(studentInfo.getId(), clazzId));
                if (attendClazzInsertResult == 1) {
                    list.add(studentInfo.getId());
                }
            } catch (Exception e) {
                logger.error("studentInfo error", e);
            }
        }
        return list;
    }

}
