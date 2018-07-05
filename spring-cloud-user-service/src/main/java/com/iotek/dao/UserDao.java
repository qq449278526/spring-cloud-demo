package com.iotek.dao;

import com.iotek.user.api.service.model.User;
import org.springframework.stereotype.Component;

/**
 * Created by 2018/7/3.
 */
@Component
public interface UserDao {

    User selectByPrimaryKey(Integer userId);

    User selectByName(User user);
}
