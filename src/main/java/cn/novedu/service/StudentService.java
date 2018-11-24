package cn.novedu.service;

import cn.novedu.bean.StudentInfo;
import cn.novedu.mapper.StudentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentInfoMapper studentInfoMapper;

    public StudentInfo findById(String id) {
        return studentInfoMapper.findById(id);
    }






}
