package cn.novedu.service;

import java.util.List;

import cn.novedu.bean.Clazz;
import cn.novedu.mapper.ClazzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    public List<Clazz> find() {
        return clazzMapper.find();
    }




}
