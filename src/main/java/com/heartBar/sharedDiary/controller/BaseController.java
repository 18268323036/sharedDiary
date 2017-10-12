package com.heartBar.sharedDiary.controller;

import com.heartBar.sharedDiary.common.util.CookieUtil;
import com.heartBar.sharedDiary.dto.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zhangxy 2017/9/28 11:14
 */
@Controller
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    protected HttpServletRequest request;
    protected HttpServletResponse response;


    public Long getUserId(){
        String sessionId = CookieUtil.findObject(request, "JSESSIONID", String.class);
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(sessionId);
        return userInfo.getId();
    }

    public void setRequest(HttpServletRequest request) {this.request = request; }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }


}
