package cn.novedu.controller;

import cn.novedu.bean.Response;
import cn.novedu.bean.StudentInfo;
import cn.novedu.bean.Team;
import cn.novedu.bean.TeamRequest;
import cn.novedu.constant.Constant;
import cn.novedu.jdbc.paging.PagingManager;
import cn.novedu.param.PagingParam;
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
    @Autowired
    private PagingManager pagingManager;
    private Logger logger = LoggerFactory.getLogger(TeamController.class);

    /**
     * 在指定班级中创建队伍
     *
     * @param token   用户token
     * @param clazzId 班级id
     * @param team    Team对象,name,describe必需
     * @return 成功则返回创建的Team
     */
    @RequestMapping(value = "/classes/{id}/teams", method = RequestMethod.POST)
    public Response postTeam(@RequestHeader(Constant.TOKEN_NAME) String token,
                             @PathVariable("id") String clazzId,
                             @Valid @RequestBody Team team) {
        String userId = userService.getUserId(token);
        //以路径中的clazzId为准
        String id = teamService.createTeam(team.getName(), team.getDescription(), clazzId, userId);
        team = teamService.findById(id);
        if (team != null) {
            return new Response().success(team);
        } else {
            return new Response().failure();
        }
    }

    /**
     * 获得班级中的所有队伍
     *
     * @param token    用户token
     * @param clazzId  班级id
     * @param pageNum  第几页
     * @param pageSize 每页几条
     * @param order    升序asc还是降序desc
     * @param sort     按什么列排序
     * @return List of Team
     */
    @RequestMapping(value = "/classes/{id}/teams", method = RequestMethod.GET)
    public Response getTeams(@RequestHeader(Constant.TOKEN_NAME) String token,
                             @PathVariable("id") String clazzId,
                             @RequestParam(value = "page", defaultValue = "0") int pageNum,
                             @RequestParam(value = "per_page", defaultValue = "0") int pageSize,
                             @RequestParam(value = "order", defaultValue = "desc") String order,
                             @RequestParam(value = "sort", defaultValue = "create_time") String sort) {
        String userId = userService.getUserId(token);
        String orderBy = pagingManager.handleOrderBy("post", sort, order);
        if (orderBy == null) {
            orderBy = "post_time asc";
        }
        PagingParam pagingParam = new PagingParam(pageNum, pageSize, orderBy);
        logger.debug(userId);
        List<Team> teamList = teamService.getTeams(userId, clazzId, pagingParam);
        if (teamList != null) {
            return new Response().success(teamList);
        } else {
            return new Response().failure();
        }
    }

    /**
     * 获得指定id的队伍信息
     *
     * @param token  用户token
     * @param teamId 队伍id
     * @return 返回查询到的队伍
     */
    @RequestMapping(value = "/teams/{team-id}", method = RequestMethod.GET)
    public Response getTeamById(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("team-id") String teamId) {
        String userId = userService.getUserId(token);
        Team team = teamService.getTeamById(userId, teamId);
        if (team != null) {
            return new Response().success(team);
        } else {
            return new Response().failure();
        }
    }

    /**
     * 删除指定的team,只有组长拥有权限
     *
     * @param token  用户token
     * @param teamId 队伍id
     * @return 成功与否
     */
    @RequestMapping(value = "/teams/{team-id}", method = RequestMethod.DELETE)
    public Response deleteTeamById(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("team-id") String teamId) {
        String userId = userService.getUserId(token);
        Boolean result = teamService.deleteTeamById(userId, teamId);
        if (result != null && result) {
            return new Response().success();
        } else {
            return new Response().failure();
        }
    }

    /**
     * 修改指定的队伍信息
     *
     * @param token   用户token
     * @param teamId  队伍id
     * @param newTeam 新的队伍对象,可选name和description
     * @return 成功修改后返回修改后的team
     */
    @RequestMapping(value = "/teams/{team-id}", method = RequestMethod.PUT)
    public Response updateTeamById(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("team-id") String teamId, @Valid @RequestBody Team newTeam) {
        String userId = userService.getUserId(token);
        Team resultTeam = teamService.updateTeamById(userId, teamId, newTeam);
        if (resultTeam != null) {
            return new Response().success(resultTeam);
        } else {
            return new Response().failure();
        }
    }

    /**
     * 请求加入指定的队伍
     *
     * @param token  用户token
     * @param teamId 队伍id
     * @return 返回成功与否
     */
    @RequestMapping(value = "teams/{team-id}/request", method = RequestMethod.POST)
    public Response postTeamRequests(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("team-id") String teamId) {
        String userId = userService.getUserId(token);
        Boolean result = teamService.insertTeamRequest(userId, teamId);
        if (result != null && result) {
            return new Response().success();
        } else {
            return new Response().failure();
        }
    }

    /**
     * 获得所有请求加入队伍的请求,只有组长有权限
     *
     * @param token  用户token
     * @param teamId 队伍id
     * @return 返回List of Request
     */
    @RequestMapping(value = "/teams/{team-id}/request", method = RequestMethod.GET)
    public Response getTeamRequests(
            @RequestHeader(Constant.TOKEN_NAME) String token,
            @PathVariable("team-id") String teamId) {
        String userId = userService.getUserId(token);
        List<TeamRequest> teamRequestList = teamService.getTeamRequests(userId, teamId);
        if (teamRequestList != null) {
            return new Response().success(teamRequestList);
        } else {
            return new Response().failure();
        }
    }

    /**
     * 处理请求信息,选择拒绝或者同意.组长才有权限
     *
     * @param token  用户token
     * @param teamId 队伍id
     * @param param  请求处理参数对象,包括请求id和处理结果
     * @return 返回最后的处理结果
     */
    @RequestMapping(value = "/teams/{team-id}/request/handler", method = RequestMethod.POST)
    public Response handleRequest(
            @RequestHeader(Constant.TOKEN_NAME) String token,
            @PathVariable("team-id") String teamId,
            @RequestBody RequestHandlerParam param) {
        String userId = userService.getUserId(token);
        Boolean result = teamService.handleRequest(userId, teamId, param.getRequestId(), param.isAccecpt());
        if (result != null && result) {
            return new Response().success(param.isAccecpt() ? "accepted" : "denied");
        } else {
            return new Response().failure();
        }
    }
}
