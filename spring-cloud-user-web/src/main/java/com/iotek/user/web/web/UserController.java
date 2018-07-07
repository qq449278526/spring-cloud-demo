package com.iotek.user.web.web;

import com.iotek.user.api.service.model.User;
import com.iotek.user.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * Created by 2018/7/5.
 */
@Controller
@RequestMapping("${version}/user")
public class UserController {
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;

    // 主页
    @RequestMapping("")
    public String index(){
        return "index";
    }

    // 调用user-service，根据用户id得到用户余额
    @RequestMapping(value = "/money",method = RequestMethod.GET)
    public String money(HashMap hashMap){
        String userInfo = "money";
        Integer userId = 14;
//        //调用user-service接口
//        //参数1：调用url；参数2：返回值类型；参数3...url填充值
//        ResponseEntity<String> entity = restTemplate.getForEntity("http://user-service/v1/user/{userInfo}/{userId}"
//                , String.class
//                , userInfo, userId);
//        String money = entity.getBody();//获得响应正文：money
//        String money = userService.getUserMoney(userInfo, userId);
        String money = userService.getUserInfo(userInfo, userId);
        hashMap.put("money",money);//页面数据填充
        return "money";
    }


    // 调用user-service，实现登录功能
    @PostMapping("/login")
    public String login(@ModelAttribute User user,HashMap hashMap){
        // 参数1：远程调用服务url；参数二：远程服务需要的参数；参数三：返回类型
//        user = restTemplate.postForObject("http://user-service/v1/user/login",user,User.class);

        // 使用Feign代替Ribbon第四步
        user = userService.login(user);
        if (user==null){
            return "index";
        }
        hashMap.put("userLogin",user);
        return "welcome";
    }
}
