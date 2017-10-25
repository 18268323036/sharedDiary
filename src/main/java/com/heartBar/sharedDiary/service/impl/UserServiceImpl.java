package com.heartBar.sharedDiary.service.impl;

import com.heartBar.sharedDiary.dao.UserDAO;
import com.heartBar.sharedDiary.dto.User;
import com.heartBar.sharedDiary.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangxy 2017/10/24 10:32
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public User findUserByUserName(String name) {
        return userDAO.findByUserName(name);
    }
}
