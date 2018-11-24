package cn.novedu.service;

import java.util.List;

import cn.novedu.bean.TeacherInfo;
import cn.novedu.mapper.TeacherInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherInfoMapper teacherInfoMapper;

    public TeacherInfo findById(String id) {
        return teacherInfoMapper.findById(id);
    }
}
