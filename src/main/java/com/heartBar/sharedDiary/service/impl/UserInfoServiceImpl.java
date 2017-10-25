package com.heartBar.sharedDiary.service.impl;

import com.heartBar.sharedDiary.common.aop.ServiceLog;
import com.heartBar.sharedDiary.common.util.ValidUtil;
import com.heartBar.sharedDiary.dao.UserInfoDAO;
import com.heartBar.sharedDiary.dto.UserInfo;
import com.heartBar.sharedDiary.service.UserInfoService;
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
    @ServiceLog("查询用户信息")
    public UserInfo queryUserInfo(UserInfo userInfo) {
        ValidUtil.paramValid(userInfo);
        UserInfo user = userInfoDAO.queryUserInfo(userInfo);
        return user;
    }

    @Override
    @ServiceLog("插入用户信息")
    public int insert(UserInfo userInfo) {
        ValidUtil.paramValid(userInfo);
        ValidUtil.paramValid(userInfo.getCode(),userInfo.getMobile(),userInfo.getName(),userInfo.getPassword(),userInfo.getUserType());
        int count = userInfoDAO.insert(userInfo);
        return count;
    }

    @Override
    public UserInfo findByUserName(String code) {
        ValidUtil.paramValid(code);
        UserInfo userInfo = userInfoDAO.findByUserName(code);
        return userInfo;
    }

}
