package com.iotek.user.api.service.apiservice;

import com.iotek.user.api.service.fallback.UserFallback;
import com.iotek.user.api.service.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 2018/7/6.
 */
// Feign代替Ribbon第一步
// value指定应用名
@FeignClient(value = "user-service",fallback = UserFallback.class)
@RequestMapping("api")
@Api(value = "UserAPI",description = "UserAPI",produces = MediaType.APPLICATION_JSON_VALUE)
public interface UserAPIService {
    @PostMapping(value = "login")
    @ApiOperation(value = "登录",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "user",value = "用户登录信息",dataType = "User")
    User login(@RequestBody User user);

    @GetMapping(value = "/{userInfo}/{userId}")
    String getUserInfo(@PathVariable(value = "userInfo") String userInfo,
                       @PathVariable(value = "userId") Integer userId);
}
