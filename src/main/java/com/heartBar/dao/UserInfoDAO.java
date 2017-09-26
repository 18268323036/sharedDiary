package com.heartBar.dao;

import com.heartBar.dto.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @author zhangxy 2017/9/26
 */
@Component
public interface UserInfoDAO {

    UserInfo queryUserInfoById(Long id);

    int insert(UserInfo userInfo);

}
