package cn.novedu.service;

import java.util.List;

import cn.novedu.bean.Team;

import cn.novedu.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Max Huang
 */
@Service
public class TeamService {
    @Autowired
    private TeamMapper teamMapper;

    public Team findById(String id) {
        return teamMapper.findById(id);
    }
}
