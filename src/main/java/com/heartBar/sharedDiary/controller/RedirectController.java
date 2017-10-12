package com.heartBar.sharedDiary.controller;

import com.heartBar.sharedDiary.common.util.CookieUtil;
import com.heartBar.sharedDiary.dto.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author zhangxy 2017/10/11 11:32
 */
@Controller
public class RedirectController extends BaseController{


    @RequestMapping(value = "indexView")
    public String indexView(){
        return "diary";
    }

    @RequestMapping(value = "loginView")
    public String loginView(Model model){
        Date date = new Date();
        request.getSession();
        String sessionId = CookieUtil.findObject(request, "JSESSIONID", String.class);
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute(sessionId);
        if(userInfo!=null){
            return "diary";
        }
        return "login";
    }
}
