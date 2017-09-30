package com.heartBar.sharedDiary.service;

import com.heartBar.sharedDiary.dto.UserCondition;

/**
 * @author zhangxy 2017/9/28
 */
public interface UserConditionService {

    int insert(UserCondition userCondition);

    UserCondition queryUserCondition(Long userId);

    int updateByUserId(UserCondition userCondition);

}
