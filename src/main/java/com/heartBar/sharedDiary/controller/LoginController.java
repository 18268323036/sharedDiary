package com.heartBar.sharedDiary.controller;

import com.heartBar.sharedDiary.common.expection.ResultEnum;
import com.heartBar.sharedDiary.common.expection.ValidException;
import com.heartBar.sharedDiary.common.util.CookieUtil;
import com.heartBar.sharedDiary.common.util.MD5Util;
import com.heartBar.sharedDiary.common.util.SecurityUtil;
import com.heartBar.sharedDiary.dto.JsonResult;
import com.heartBar.sharedDiary.dto.User;
import com.heartBar.sharedDiary.dto.UserCondition;
import com.heartBar.sharedDiary.dto.UserInfo;
import com.heartBar.sharedDiary.service.UserConditionService;
import com.heartBar.sharedDiary.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxy 2017/9/29 10:51
 */
@Controller
public class LoginController extends BaseController{

    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserConditionService userConditionService;

    @RequestMapping(value = "login2")
    @ResponseBody
    public Object login(String code,String password,Byte registSource) throws Exception {
        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(password)){
            throw new ValidException(ResultEnum.PARAM_ERROR);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setCode(code);
        userInfo = userInfoService.queryUserInfo(userInfo);
        if(userInfo!=null){
            if(!userInfo.getPassword().equals(MD5Util.MD5(password))){
                throw new ValidException(ResultEnum.PASSWORD_ERROR);
            }
            UserCondition userCondition = new UserCondition();
            Long userId = userInfo.getId();
            Map<String,Object> map = new HashMap<>();
            map.put("userId",userId);
            map.put("code",code);
            String token = SecurityUtil.authentication(map);
            userCondition.setUserId(userId);
            userCondition.setLastLoginClient(registSource);
            userCondition.setLastLoginTime(new Date());
            if(registSource==1){
                userCondition.setWebToken(token);
            }else if(registSource==2){
                userCondition.setAppToken(token);
            }else{
                userCondition.setWebToken(token);
            }
            if(userConditionService.updateByUserId(userCondition)>0){
                String sessionId = CookieUtil.findObject(request, "JSESSIONID", String.class);
                request.getSession().setAttribute(sessionId,userInfo);
                return JsonResult.getOkJsonObj(userCondition);
            }else{
                return JsonResult.getOkJsonObj(null);
            }
        }else{
            throw new ValidException(ResultEnum.MOBILE_HASNOT_REGIST);
        }
    }


    @RequestMapping("/login")
    @ResponseBody
    public Object loginUser(String code,String password,HttpSession session) {
        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(password)){
            throw new ValidException(ResultEnum.PARAM_ERROR);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setCode(code);
        userInfo = userInfoService.queryUserInfo(userInfo);
        if(userInfo!=null){
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(code,password);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(usernamePasswordToken);
                UserInfo user=(UserInfo) subject.getPrincipal();
                String sessionId = CookieUtil.findObject(request, "JSESSIONID", String.class);
                request.getSession().setAttribute(sessionId,user);
                return JsonResult.getOkJsonObj(null);
            } catch(Exception e) {
                throw new ValidException(ResultEnum.PASSWORD_ERROR);
            }
        }else{
            throw new ValidException(ResultEnum.MOBILE_HASNOT_REGIST);
        }
    }

    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

}
