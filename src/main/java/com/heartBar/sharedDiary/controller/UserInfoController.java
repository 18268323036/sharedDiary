package com.heartBar.sharedDiary.controller;

import com.heartBar.sharedDiary.dto.UserInfo;

import com.heartBar.sharedDiary.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author zhangxy 2017/9/26 17:25
 */
public class UserInfoController extends BaseController{

    @Resource
    private UserInfoService userInfoService;


    @RequestMapping(value = "insert")
    public Object insert(UserInfo userInfo){
        return userInfoService.insert(userInfo);
    }

    @RequestMapping(value = "queryUserInfoById")
    public Object queryUserInfo(Long id){
        return userInfoService.queryUserInfoById(id);
    }



}
