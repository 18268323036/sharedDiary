package com.heartBar.sharedDiary.controller;

import com.heartBar.sharedDiary.dto.UserInfo;

import com.heartBar.sharedDiary.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangxy 2017/9/26 17:25
 */
@RestController
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;


    @RequestMapping(value = "insert")
    public Object insert(UserInfo userInfo){
        return userInfoService.insert(userInfo);
    }

    @RequestMapping(value = "queryUserInfo")
    public Object queryUserInfo(Long id){
        return userInfoService.queryUserInfoById(id);
    }

    @RequestMapping(value = "helloWorld")
    public Object helloWorld(){
        UserInfo userInfo = new UserInfo();
        userInfo.setMobile("18268323036");
        userInfo.setCode("18268323036");
        userInfo.setName("张翔耀");
        userInfo.setUserType((byte)1);
        userInfo.setPassword("123456");
        return userInfo;
    }

}
