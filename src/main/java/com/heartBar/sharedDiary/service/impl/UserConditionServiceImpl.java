package com.heartBar.sharedDiary.service.impl;

import com.heartBar.sharedDiary.common.aop.ServiceLog;
import com.heartBar.sharedDiary.common.util.ValidUtil;
import com.heartBar.sharedDiary.dao.UserConditionDAO;
import com.heartBar.sharedDiary.dto.UserCondition;
import com.heartBar.sharedDiary.service.UserConditionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangxy 2017/9/28 16:57
 */
@Service
public class UserConditionServiceImpl implements UserConditionService {

    @Resource
    private UserConditionDAO userConditionDAO;


    @Override
    @ServiceLog("插入用户状态信息")
    public int insert(UserCondition userCondition) {
        ValidUtil.paramValid(userCondition);
        int result = userConditionDAO.insert(userCondition);
        return result;
    }

    @Override
    @ServiceLog("查询用户状态信息")
    public UserCondition queryUserCondition(Long userId) {
        ValidUtil.paramValid(userId);
        UserCondition user = userConditionDAO.selectByUserId(userId);
        return user;
    }

    @Override
    @ServiceLog("根据用户id更新用户状态信息")
    public int updateByUserId(UserCondition userCondition) {
        ValidUtil.paramValid(userCondition);
        int result = userConditionDAO.updateByUserId(userCondition);
        return result;
    }
}
