package com.heartBar.sharedDiary.dao;

import com.heartBar.sharedDiary.dto.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @author zhangxy 2017/9/27 16:15
 */
@Component
public interface UserInfoDAO {

    UserInfo queryUserInfoById(Long id);

    UserInfo queryUserInfo(UserInfo userInfo);

    int insert(UserInfo userInfo);
}
