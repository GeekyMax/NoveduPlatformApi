package cn.novedu.controller;

import cn.novedu.bean.Bulletin;
import cn.novedu.bean.Response;
import cn.novedu.constant.Constant;
import cn.novedu.jdbc.paging.PagingManager;
import cn.novedu.param.PagingParam;
import cn.novedu.service.BulletinService;
import cn.novedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Max Huang
 */
@RestController
public class BulletinController {
    @Autowired
    private BulletinService bulletinService;
    @Autowired
    private UserService userService;
    @Autowired
    private PagingManager pagingManager;

    @RequestMapping(value = "/classes/{class-id}/bulletin", method = RequestMethod.POST)
    public Response postBulletin(@RequestHeader(Constant.TOKEN_NAME) String token,
                                 @PathVariable("class-id") String clazzId,
                                 @RequestBody Bulletin bulletin) {
        String userId = userService.getUserId(token);
        Bulletin resultBulletin = bulletinService.postBulletin(clazzId, userId, bulletin);
        return new Response().success(resultBulletin);
    }

    @RequestMapping(value = "/classes/{class-id}/bulletin", method = RequestMethod.GET)
    public Response getBulletin(@RequestHeader(Constant.TOKEN_NAME) String token,
                                @PathVariable("class-id") String clazzId,
                                @RequestParam(value = "page", defaultValue = "0") int pageNum,
                                @RequestParam(value = "per_page", defaultValue = "0") int pageSize,
                                @RequestParam(value = "order", defaultValue = "desc") String order,
                                @RequestParam(value = "sort", defaultValue = "create_time") String sort
    ) {
        String userId = userService.getUserId(token);
        PagingParam pagingParam = pagingManager.createPagingParam(pageNum, pageSize, order, sort);
        List<Bulletin> bulletinList = bulletinService.getBulletins(userId, clazzId, pagingParam);
        return new Response().success(bulletinList);
    }

    @RequestMapping(value = "/bulletin/{id}", method = RequestMethod.DELETE)
    public Response deleteBulletin(@RequestHeader(Constant.TOKEN_NAME) String token, @PathVariable("id") String bulletinId) {
        String userId = userService.getUserId(token);
        int result = bulletinService.deleteBulletin(userId, bulletinId);
        if (result == 1) {
            return new Response().success();
        } else {
            return new Response().failure();
        }
    }
}
