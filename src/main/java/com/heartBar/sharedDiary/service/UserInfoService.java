package com.heartBar.sharedDiary.service;


import com.heartBar.sharedDiary.dto.UserInfo;

/**
 * @author zhangxy 2017/9/26 14:45
 */
public interface UserInfoService {

    UserInfo queryUserInfoById(Long id);

    UserInfo queryUserInfo(UserInfo userInfo);

    int insert(UserInfo userInfo);

}
