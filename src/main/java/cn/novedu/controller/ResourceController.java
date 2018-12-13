package cn.novedu.controller;

import cn.novedu.bean.ClazzResource;
import cn.novedu.bean.Response;
import cn.novedu.constant.Constant;
import cn.novedu.constant.UserType;
import cn.novedu.security.IgnoreSecurity;
import cn.novedu.service.FileService;
import cn.novedu.service.UserService;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Max Huang
 */
@Controller
public class ResourceController {
    @Autowired
    UserService userService;
    @Autowired
    FileService fileService;
    private Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @IgnoreSecurity
    @ResponseBody
    @RequestMapping(value = "/classes/{id}/resources", method = RequestMethod.POST)
    public Response uploadResource(@RequestHeader(value = Constant.TOKEN_NAME, required = false) String token, @PathVariable("id") String clazzId,
                                   @RequestParam(value = "file") MultipartFile multipartFile,
                                   @RequestParam(value = "detail", defaultValue = "") String detail,
                                   @RequestParam(value = "name", defaultValue = "resource") String name) throws Exception {
        logger.debug(multipartFile.getName());
        logger.debug(multipartFile.getContentType());
        logger.debug(multipartFile.getOriginalFilename());
        logger.debug("" + multipartFile.getSize());
        logger.debug(detail);

        logger.debug(name);
        String userId1 = userService.getUserId(token);
        logger.debug(userId1);
        String userId = "39078df7c84f48c58f14fb9678b28bec";
        UserType userType = userService.findUserTypeById(userId);
        Assert.assertEquals(userType, UserType.TEACHER);
        ClazzResource clazzResource = fileService.uploadResource(multipartFile, clazzId, userId, name, detail);
        return new Response().success(clazzResource);
    }

    @IgnoreSecurity
    @RequestMapping(value = "/resources/{id}", method = RequestMethod.GET)
    public void downloadResource(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String resourceId) throws Exception {
        fileService.downloadBigFile(request, response, resourceId);
    }
}
