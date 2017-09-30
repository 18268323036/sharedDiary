package com.heartBar.sharedDiary.controller;

import com.heartBar.sharedDiary.common.enums.SexEnum;
import com.heartBar.sharedDiary.common.enums.UserType;
import com.heartBar.sharedDiary.common.expection.ResultEnum;
import com.heartBar.sharedDiary.common.expection.ValidException;
import com.heartBar.sharedDiary.common.util.CookieUtil;
import com.heartBar.sharedDiary.common.util.MD5Util;
import com.heartBar.sharedDiary.common.util.SecurityUtil;
import com.heartBar.sharedDiary.common.util.ValidUtil;
import com.heartBar.sharedDiary.dto.JsonResult;
import com.heartBar.sharedDiary.dto.UserCondition;
import com.heartBar.sharedDiary.dto.UserInfo;
import com.heartBar.sharedDiary.service.UserConditionService;
import com.heartBar.sharedDiary.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxy 2017/9/28 11:13
 */
@Controller
public class RegisterController extends BaseController{

    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserConditionService userConditionService;

    /**
     * 注册
     * @param mobile
     * @param password
     * @param captcha
     * @return
     */
    @RequestMapping(value = "register")
    @ResponseBody
    public Object register(String mobile,String password,String captcha,Byte registResource) throws Exception {
        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password) || StringUtils.isEmpty(captcha)){
            throw new ValidException(ResultEnum.PARAM_ERROR);
        }
        if(!ValidUtil.validatePhone(mobile)){
            throw new ValidException(ResultEnum.MOBILE_FORMAT_ERROR);
        }
        UserInfo user = new UserInfo();
        user.setMobile(mobile);
        user.setCode(mobile);
        if(userInfoService.queryUserInfo(user)!=null){
            throw new ValidException(ResultEnum.MOBILE_HAS_REGISTERED);
        }
        user.setUserType(UserType.COMMON_USER.getCode());
        user.setName("用户"+mobile.substring(7));
        user.setRegistSource(registResource);
        user.setPassword(MD5Util.MD5(password).toUpperCase());
        user.setSex(SexEnum.MALE.getCode());
        if(userInfoService.insert(user)>0){
            UserCondition userCondition = new UserCondition();
            Map<String,Object> map = new HashMap<>();
            map.put("registSource",registResource);
            map.put("code",mobile);
            String token = SecurityUtil.authentication(map);
            Long userId = user.getId();
            if(registResource==1){
                userCondition.setWebToken(token);
            }else if(registResource==2){
                userCondition.setAppToken(token);
            }else{
                userCondition.setWebToken(token);
            }
            userCondition.setUserId(userId);
            userCondition.setLastLoginClient(registResource);
            userCondition.setLastLoginTime(new Date());
            if(userConditionService.insert(userCondition)>0){
                String sessionId = CookieUtil.findObject(request, "sessionId", String.class);
                request.getSession().setAttribute(sessionId,user);
                return JsonResult.getOkJsonObj(userCondition);
            }else{
                return JsonResult.getOkJsonObj(null);
            }
        }else{
            return new JsonResult<>(ResultEnum.REGIST_FILED);
        }
    }



}
