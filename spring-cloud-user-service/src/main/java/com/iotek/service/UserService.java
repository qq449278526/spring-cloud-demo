package com.iotek.service;


import com.iotek.user.api.service.model.User;

/**
 * Created by 2018/7/3.
 */
public interface UserService {
    User selectByPrimaryKey(Integer userId);
    User selectByName(User user);
}
