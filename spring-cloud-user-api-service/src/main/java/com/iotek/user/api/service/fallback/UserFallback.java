package com.iotek.user.api.service.fallback;

import com.iotek.user.api.service.apiservice.UserAPIService;
import com.iotek.user.api.service.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 2018/7/6.
 */
@Component
public class UserFallback implements UserAPIService {
    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public String getUserInfo(String userInfo, Integer userId) {
        return "error";
    }
}
