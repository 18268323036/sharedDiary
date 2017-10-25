package com.heartBar.sharedDiary.dao;

import com.heartBar.sharedDiary.dto.User;

/**
 * @author zhangxy 2017/10/24
 */
public interface UserDAO {

    public User findByUserName(String username);

}
