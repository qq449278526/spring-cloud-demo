package com.iotek.service.impl;

import com.iotek.dao.UserDao;
import com.iotek.service.UserService;
import com.iotek.user.api.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 2018/7/3.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public User selectByName(User user) {
        return userDao.selectByName(user);
    }
}
