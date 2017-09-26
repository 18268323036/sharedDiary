package com.heartBar.service;

import com.heartBar.dto.UserInfo;

/**
 * @author zhangxy 2017/9/26 14:45
 */
public interface UserInfoService {

    UserInfo queryUserInfoById(Long id);

    int insert(UserInfo userInfo);
}
