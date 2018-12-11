package cn.novedu.service;

import cn.novedu.bean.Bulletin;
import cn.novedu.mapper.AttendClazzMapper;
import cn.novedu.mapper.BulletinMapper;
import cn.novedu.mapper.TeachClazzMapper;
import cn.novedu.param.PagingParam;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Max Huang
 */
@Service
public class BulletinService {
    @Autowired
    private TeachClazzMapper teachClazzMapper;
    @Autowired
    private BulletinMapper bulletinMapper;
    @Autowired
    private AttendClazzMapper attendClazzMapper;

    public Bulletin postBulletin(String clazzId, String userId, Bulletin bulletin) {
        bulletin.setClazzId(clazzId);
        Assert.assertTrue(teachClazzMapper.judgeTeacherInClazz(userId, clazzId));
        if (bulletinMapper.insert(bulletin) == 1) {
            return bulletin;
        } else {
            return null;
        }
    }

    public List<Bulletin> getBulletins(String userId, String clazzId, PagingParam pagingParam) {
        Assert.assertTrue(teachClazzMapper.judgeTeacherInClazz(userId, clazzId) || attendClazzMapper.judgeStudentInClazz(userId, clazzId));
        return bulletinMapper.findByClazzId(clazzId, pagingParam.getPageNum(), pagingParam.getPageSize(), pagingParam.getOrderBy());
    }
}
