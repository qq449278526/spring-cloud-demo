package com.iotek.user.web.service;

import com.iotek.user.api.service.apiservice.UserAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Service
//public class UserService {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @HystrixCommand(fallbackMethod = "getUserMoneyFallBack")
//    public String getUserMoney(String userInfo,Integer userId){
//        ResponseEntity<String> entity = restTemplate.getForEntity("http://user-service/v1/user/{userInfo}/{userId}"
//                , String.class
//                , userInfo, userId);
//        String money = entity.getBody();//获得响应正文：money
//        return money;
//    }
//
//    // 当getUserMoney方法出错时，调用此方法
//    public String getUserMoneyFallBack(String userInfo,Integer userId){
//        return "error";
//    }
//}

// 使用Feign代替Ribbon第三步
@FeignClient(value = "user-service")
public interface UserService extends UserAPIService{

}