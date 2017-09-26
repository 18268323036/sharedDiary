package com.heartBar.service.impl;

import com.heartBar.common.aop.ServiceLog;
import com.heartBar.common.util.ValidUtil;
import com.heartBar.dao.UserInfoDAO;
import com.heartBar.dto.UserInfo;
import com.heartBar.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangxy 2017/9/26 14:46
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDAO userInfoDAO;

    @Override
    @ServiceLog("根据id查询用户信息")
    public UserInfo queryUserInfoById(Long id) {
        ValidUtil.paramValid(id);
        UserInfo userInfo = userInfoDAO.queryUserInfoById(id);
        return userInfo;
    }

    @Override
    public int insert(UserInfo userInfo) {
        ValidUtil.paramValid(userInfo);
        ValidUtil.paramValid(userInfo.getCode(),userInfo.getMobile(),userInfo.getName(),userInfo.getPassword(),userInfo.getUserType());
        int count = userInfoDAO.insert(userInfo);
        return count;
    }
}
