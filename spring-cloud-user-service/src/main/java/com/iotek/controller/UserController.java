package com.iotek.controller;

import com.iotek.service.UserService;
import com.iotek.user.api.service.apiservice.UserAPIService;
import com.iotek.user.api.service.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 2018/7/3.
 */
// Feign代替Ribbon第二步：去掉RequestMapping，继承UserAPIService
@RestController
//@RequestMapping(value = "${version}/user")
//@Api(value = "UserController",description = "UserController",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController implements UserAPIService{
    @Autowired
    private UserService userService;

    @Override
    @PostMapping(value = "login")
    @ApiOperation(value = "登录",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "user",value = "用户登录信息",dataType = "User")
    public User login(@RequestBody User user) {
        return userService.selectByName(user);
    }

    @Override
    @GetMapping(value = "/{userInfo}/{userId}")
    public String getUserInfo(@PathVariable(value = "userInfo") String userInfo,
                              @PathVariable(value = "userId") Integer userId){
        if (userInfo.equals("money")){
            return userService.selectByPrimaryKey(userId).getMoney().toString();
        }
        return null;
    }
}
