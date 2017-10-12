package com.heartBar.sharedDiary.common;

import com.heartBar.sharedDiary.common.util.CookieUtil;
import com.heartBar.sharedDiary.dto.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangxy 2017/9/29 15:42
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionId = CookieUtil.findObject(request, "JSESSIONID", String.class);
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute(sessionId);
        if(userInfo==null){
            response.sendRedirect(request.getContextPath() + "/loginView");
            return false;
        }else{
            return super.preHandle(request, response, handler);
        }
    }

}
