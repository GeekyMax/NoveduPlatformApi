package cn.novedu.service;

import java.util.List;

import cn.novedu.bean.Clazz;
import cn.novedu.mapper.AttachClazzMapper;
import cn.novedu.mapper.ClazzMapper;
import cn.novedu.mapper.TeachClazzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private TeachClazzMapper teachClazzMapper;
    @Autowired
    private AttachClazzMapper attachClazzMapper;

    public List<Clazz> find() {
        return clazzMapper.find();
    }

    public List<Clazz> findByStudentId(String studentId) {
        return clazzMapper.findByStudentId(studentId);
    }

    public List<Clazz> findByTeacherId(String teacherId) {
        return clazzMapper.findByTeacherId(teacherId);
    }

    public Clazz findByStudentIdAndClazzId(String studentId, String clazzId) {
        Integer count = attachClazzMapper.countByStudentIdAndClazzId(studentId, clazzId);
        if (count != null && count > 0) {
            return clazzMapper.findById(clazzId);
        } else {
            return null;
        }
    }

    public Clazz findByTeacherIdAndClazzId(String teacherId, String clazzId) {
        Integer count = teachClazzMapper.countByTeacherIdAndClazzId(teacherId, clazzId);
        if (count != null && count > 0) {
            return clazzMapper.findById(clazzId);
        } else {
            return null;
        }
    }
}
