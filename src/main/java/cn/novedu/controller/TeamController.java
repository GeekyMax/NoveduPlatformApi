package cn.novedu.controller;

import cn.novedu.bean.Response;
import cn.novedu.bean.StudentInfo;
import cn.novedu.bean.Team;
import cn.novedu.bean.TeamRequest;
import cn.novedu.constant.Constant;
import cn.novedu.param.RequestHandlerParam;
import cn.novedu.service.TeamService;
import cn.novedu.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author Max Huang
 */
@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(TeamController.class);

    @RequestMapping(value = "/classes/{id}/teams", method = RequestMethod.POST)
    public Response postTeam(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("id") String clazzId, @Valid @RequestBody Team team) {
        String userId = userService.getUserId(token);
        try {
            //以路径中的clazzId为准
            String id = teamService.createTeam(team.getName(), team.getDescription(), clazzId, userId);
            team = teamService.findById(id);
            if (team != null) {
                return new Response().success(team);
            } else {
                return new Response().failure();
            }
        } catch (Exception e) {
            logger.error("error", e);
            return new Response().failure(e.getMessage());
        }
    }

    @RequestMapping(value = "/classes/{id}/teams", method = RequestMethod.GET)
    public Response getTeams(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("id") String clazzId) {
        logger.debug(token, clazzId);
        String userId = userService.getUserId(token);
        logger.debug(userId);
        List<Team> teamList = teamService.getTeams(userId, clazzId);
        if (teamList != null) {
            return new Response().success(teamList);
        } else {
            return new Response().failure();
        }
    }

    @RequestMapping(value = "/classes/{class-id}/teams/{team-id}", method = RequestMethod.GET)
    public Response getTeamById(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("class-id") String clazzId, @PathVariable("team-id") String teamId) {
        String userId = userService.getUserId(token);
        Team team = teamService.getTeamById(userId, clazzId, teamId);
        if (team != null) {
            return new Response().success(team);
        } else {
            return new Response().failure();
        }
    }

    @RequestMapping(value = "/classes/{class-id}/teams/{team-id}", method = RequestMethod.DELETE)
    public Response deleteTeamById(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("class-id") String clazzId, @PathVariable("team-id") String teamId) {
        String userId = userService.getUserId(token);
        Boolean result = teamService.deleteTeamById(userId, clazzId, teamId);
        if (result != null && result) {
            return new Response().success();
        } else {
            return new Response().failure();
        }
    }

    /**
     * teamId以路径中的为准
     *
     * @param token
     * @param clazzId
     * @param teamId
     * @param newTeam
     * @return
     */
    @RequestMapping(value = "/classes/{class-id}/teams/{team-id}", method = RequestMethod.PUT)
    public Response updateTeamById(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("class-id") String clazzId, @PathVariable("team-id") String teamId, @Valid @RequestBody Team newTeam) {
        String userId = userService.getUserId(token);
        Team resultTeam = teamService.updateTeamById(userId, clazzId, teamId, newTeam);
        if (resultTeam != null) {
            return new Response().success(resultTeam);
        } else {
            return new Response().failure();
        }
    }

    @RequestMapping(value = "/classes/{class-id}/teams/{team-id}/request", method = RequestMethod.POST)
    public Response postTeamRequests(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("class-id") String clazzId, @PathVariable("team-id") String teamId) {
        String userId = userService.getUserId(token);
        Boolean result = teamService.insertTeamRequest(userId, clazzId, teamId);
        if (result != null && result) {
            return new Response().success();
        } else {
            return new Response().failure();
        }
    }

    @RequestMapping(value = "/classes/{class-id}/teams/{team-id}/request", method = RequestMethod.GET)
    public Response getTeamRequests(
            @RequestHeader(Constant.TOKEN_NAME) String token,
            @PathVariable("class-id") String clazzId,
            @PathVariable("team-id") String teamId) {
        String userId = userService.getUserId(token);
        List<TeamRequest> teamRequestList = teamService.getTeamRequests(userId, clazzId, teamId);
        if (teamRequestList != null) {
            return new Response().success(teamRequestList);
        } else {
            return new Response().failure();
        }
    }

    @RequestMapping(value = "/classes/{class-id}/teams/{team-id}/request/handler", method = RequestMethod.POST)
    public Response handleRequest(
            @RequestHeader(Constant.TOKEN_NAME) String token,
            @PathVariable("class-id") String clazzId,
            @PathVariable("team-id") String teamId,
            @RequestBody RequestHandlerParam param) {
        String userId = userService.getUserId(token);
        Boolean result = teamService.handleRequest(userId, clazzId, teamId, param.getRequestId(), param.isAccecpt());
        if (result != null && result) {
            return new Response().success(param.isAccecpt() ? "accepted" : "denied");
        } else {
            return new Response().failure();
        }
    }
}
