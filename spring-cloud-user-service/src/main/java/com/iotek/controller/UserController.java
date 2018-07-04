package com.iotek.controller;

import com.iotek.model.User;
import com.iotek.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 2018/7/3.
 */
@RestController
@RequestMapping(value = "${version}/user")
@Api(value = "UserController",description = "UserController",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "login")
    @ApiOperation(value = "登录",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "user",value = "用户登录信息",dataType = "User")
    public User login(@ModelAttribute User user) {
        return userService.selectByName(user);
    }

    @GetMapping(value = "/{userId}")
    @ApiOperation(value = "通过用户id查询用户",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "userId",value = "用户id",dataType = "Integer",required = true,paramType = "path")
    public User login(@PathVariable Integer userId) {
        return userService.selectByPrimaryKey(userId);
    }
}
