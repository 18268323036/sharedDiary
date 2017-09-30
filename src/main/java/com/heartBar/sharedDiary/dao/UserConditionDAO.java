package com.heartBar.sharedDiary.dao;


import com.heartBar.sharedDiary.dto.UserCondition;

public interface UserConditionDAO {

    int deleteByPrimaryKey(Long id);

    int insert(UserCondition record);

    int insertSelective(UserCondition record);

    UserCondition selectByUserId(Long userId);

    int updateByPrimaryKeySelective(UserCondition record);

    int updateByPrimaryKey(UserCondition record);

    int updateByUserId(UserCondition record);
}