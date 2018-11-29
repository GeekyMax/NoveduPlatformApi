package cn.novedu.service;

import java.util.Date;
import java.util.List;

import cn.novedu.bean.*;

import cn.novedu.constant.TeamRequestState;
import cn.novedu.constant.UserType;
import cn.novedu.mapper.*;
import cn.novedu.param.PagingParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Max Huang
 */
@Service
public class TeamService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private AttendClazzMapper attendClazzMapper;
    @Autowired
    private ClazzSettingMapper clazzSettingMapper;
    @Autowired
    private TeachClazzMapper teachClazzMapper;
    @Autowired
    private TeamRequestMapper teamRequestMapper;

    public Team findById(String id) {
        return teamMapper.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public String createTeam(Team team) {
        return createTeam(team.getName(), team.getDescription(), team.getClazzId(), team.getLeader() == null ? null : team.getLeader().getId());
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public String createTeam(String name, String description, String clazzId, String leaderId) {
        AttendClazz attendClazz = attendClazzMapper.findByStudentIdAndClazzId(leaderId, clazzId);
        if (attendClazz == null) {
            throw new RuntimeException("not in clazz");
        }
        if (attendClazz.getTeamId() != null && !"".equals(attendClazz.getTeamId())) {
            throw new RuntimeException("already in a team");
        }
        ClazzSetting clazzSetting = clazzSettingMapper.findByClazzId(clazzId);
        if (clazzSetting == null) {
            throw new RuntimeException("clazz does not exist");
        }
        if (!clazzSetting.getTeamAllowed()) {
            throw new RuntimeException("not allowed");
        }
        Integer existedTeamCount = teamMapper.countByClazzId(clazzId);
        if (existedTeamCount >= clazzSetting.getMaxTeamCount()) {
            throw new RuntimeException("team number limit");
        }
        Team team = new Team(name, description, clazzId, new StudentInfo(leaderId, null, null));
        int result = teamMapper.insertSelective(team);
        if (result != 1 || team.getId() == null) {
            throw new RuntimeException("team insert fail");
        }
        attendClazzMapper.updateTeamIdByStudentIdAndClazzId(team.getId(), leaderId, clazzId);
        return team.getId();
    }

    public List<Team> getTeams(String userId, String clazzId, PagingParam pagingParam) {
        boolean inClazz = attendClazzMapper.countByStudentIdAndClazzId(userId, clazzId) > 0;
        if (!inClazz) {
            return null;
        }
        return teamMapper.findByClazzIdWithPaging(clazzId, pagingParam.getPageNum(), pagingParam.getPageSize(), pagingParam.getOrderBy());
    }

    public Team getTeamById(String userId, String teamId) {
        UserType userType = userMapper.findUserTypeById(userId);
        if (userType == UserType.STUDENT) {
            boolean inClazz = attendClazzMapper.judgeStudentInClazz(userId, teamId);
            if (!inClazz) {
                return null;
            }
            return teamMapper.findById(teamId);
        } else {
            boolean inClazz = teachClazzMapper.judgeTeacherInClazz(userId, teamId);
            if (!inClazz) {
                return null;
            }
            return teamMapper.findById(teamId);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public Boolean deleteTeamById(String userId, String teamId) {
        UserType userType = userMapper.findUserTypeById(userId);
        int result = 0;
        if (userType == UserType.STUDENT) {
            result = teamMapper.deleteByIdAndLeaderId(teamId, userId);
        } else if (userType == UserType.TEACHER) {
            String clazzId = teamMapper.findClazzIdById(teamId);
            if (teachClazzMapper.countByTeacherIdAndClazzId(userId, clazzId) == 1) {
                result = teamMapper.deleteById(teamId);
            }
        }
        if (result > 1) {
            throw new RuntimeException();
        } else {
            return result == 1;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public Team updateTeamById(String userId, String teamId, Team newTeam) {
        newTeam.setId(teamId);
        newTeam.setClazzId(null);
        newTeam.setLeader(new StudentInfo(userId, null, null));
        if (teamMapper.existByIdAndLeaderId(teamId, userId)) {
            int result = teamMapper.updateByPrimaryKeySelective(newTeam);
            if (result != 1) {
                throw new RuntimeException();
            } else {
                return teamMapper.findById(teamId);
            }
        }
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public Boolean insertTeamRequest(String userId, String teamId) {
        String clazzId = teamMapper.findClazzIdById(teamId);
        if (userMapper.findUserTypeById(userId) != UserType.STUDENT) {
            throw new RuntimeException("not a student");
        }
        AttendClazz attendClazz = attendClazzMapper.findByStudentIdAndClazzId(userId, clazzId);
        if (attendClazz == null) {
            throw new RuntimeException("not in clazz");
        }
        if (attendClazz.getTeamId() != null && !"".equals(attendClazz.getTeamId())) {
            throw new RuntimeException("already in a team");
        }
        ClazzSetting clazzSetting = clazzSettingMapper.findByClazzId(clazzId);
        if (clazzSetting == null) {
            throw new RuntimeException("clazz does not exist");
        }
        if (!clazzSetting.getTeamAllowed()) {
            throw new RuntimeException("not allowed");
        }
        Team team = teamMapper.findById(teamId);
        if (team == null) {
            throw new RuntimeException("team not exist");
        }
        if (team.getMemberNumber() >= clazzSetting.getMaxTeamMemberCount()) {
            throw new RuntimeException("team member number limit");
        }
        /**
         * 如果上一次的申请还未处理,这一次不能发布
         */
        if (teamRequestMapper.countByStudentIdAndTeamIdAndTeamRequestState(userId, teamId, "PENDING") != 0) {
            throw new RuntimeException("you have requested");
        }
        return 1 == teamRequestMapper.insert(new TeamRequest(userId, teamId));
    }

    public List<TeamRequest> getTeamRequests(String userId, String teamId) {
        if (userMapper.findUserTypeById(userId) != UserType.STUDENT) {
            return null;
        }
        if (!teamMapper.existByIdAndLeaderId(teamId, userId)) {
            return null;
        }
        return teamRequestMapper.findByTeamId(teamId);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {RuntimeException.class})
    public Boolean handleRequest(String userId, String teamId, String requestId, boolean isAccept) {
        // 权限检查
        if (!teamMapper.existByIdAndLeaderId(teamId, userId)) {
            throw new RuntimeException("permission denied");
        }
        TeamRequest teamRequest = teamRequestMapper.findById(requestId);
        if (teamRequest == null || !teamRequest.getTeamId().equals(teamId)) {
            throw new RuntimeException("illegal request");
        }
        if (teamRequest.getTeamRequestState() != TeamRequestState.PENDING) {
            throw new RuntimeException("request has been handled");
        }
        // 检查人数是否已经满
        String clazzId = teamMapper.findClazzIdById(teamId);
        ClazzSetting clazzSetting = clazzSettingMapper.findByClazzId(clazzId);
        int studentCountInTeam = attendClazzMapper.countByTeamId(teamId);
        if (studentCountInTeam >= clazzSetting.getMaxTeamMemberCount()) {
            throw new RuntimeException("team member number limit");
        }
        // 更新请求信息
        Integer result;
        result = teamRequestMapper.updateTeamRequestStateById(isAccept ? TeamRequestState.ACCEPTED : TeamRequestState.DENIED, requestId);
        if (result != 1) {
            throw new RuntimeException();
        }
        if (isAccept) {
            // 更新小组信息
            result = teamMapper.increaseMemberNumberById(teamId);
            if (result != 1) {
                throw new RuntimeException();
            }
            // 更新学生参加班级信息
            String studentId = teamRequest.getStudentId();
            result = attendClazzMapper.updateTeamIdByStudentIdAndClazzId(teamId, studentId, clazzId);
            if (result != 1) {
                throw new RuntimeException();
            }
        }
        return true;
    }
}
