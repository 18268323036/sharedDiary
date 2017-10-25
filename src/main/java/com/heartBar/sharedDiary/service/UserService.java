package com.heartBar.sharedDiary.service;

import com.heartBar.sharedDiary.dto.User;

/**
 * @author zhangxy 2017/10/24
 */
public interface UserService {

    public User findUserByUserName(String name);

}
