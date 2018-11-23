package cn.novedu.controller;

import cn.novedu.bean.Response;
import cn.novedu.util.StringUtil;
import cn.novedu.param.LoginParam;
import cn.novedu.security.IgnoreSecurity;
import cn.novedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Max Huang
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @IgnoreSecurity
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Response login(
            @Valid @RequestBody LoginParam loginParam
    ) {
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        String token = userService.login(username, password);
        if (StringUtil.isNotEmpty(token)) {
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            return new Response().success(map);
        } else {
            return new Response().failure("error username or password");
        }
    }

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public Response welcome() {
        return new Response().success("welcome");
    }
}

