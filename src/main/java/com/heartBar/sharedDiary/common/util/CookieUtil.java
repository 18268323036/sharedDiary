package com.heartBar.sharedDiary.common.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author zhangxy 2017/9/28 11:04
 */
public class CookieUtil {

    private static Logger logger = LoggerFactory.getLogger(CookieUtil.class);

    private static String cookiePath;

    private static String userCookie;


    /**
     * 设置一个30分钟的cookie
     *
     * @param cookieName
     * @param cookieValue
     * @param response
     */
    public static void setCookie(String cookieName, String cookieValue, HttpServletResponse response) {
        setCookie(cookieName,cookieValue,response,1800);
    }

    /**
     * @param cookieName
     * @param cookieValue
     * @param response
     * @param time        保存时长  秒
     */
    public static void setCookie(String cookieName, String cookieValue, HttpServletResponse response, Integer time) {
//        Cookie cookie = new Cookie(cookieName, cookieValue);
//        cookie.setMaxAge(time);
//        cookie.setPath(cookiePath);
////        cookie.setSecure(Boolean.TRUE);
//        response.addCookie(cookie);
        // 上面的方法 EDGE与IE cookie写不进。
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis() + (time * 1000L));
        Date date = new Date(sqlDate.getTime());
        StringBuilder sb=getCookieStr(new CookieUnit(cookieName,cookieValue,cookiePath,"/",date,false,true));
        response.addHeader("Set-Cookie",sb.toString());
    }

    /**
     * 移除cookie
     *
     * @param cookieName
     * @param response
     */
    public static void clearCookie(String cookieName, HttpServletResponse response) {
        Date date = DateUtil.parseDateFromStr(DateUtil.getBeforeDay(),"yyyy-MM-dd");
        StringBuilder sb=getCookieStr(new CookieUnit(cookieName,"",cookiePath,"/", date,false,true));
        response.addHeader("Set-Cookie",sb.toString());

    }

    private static Map<String, Cookie> readCookieByMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }

        }
        return cookieMap;
    }

    public static Cookie findCookie(String cookieName, HttpServletRequest request) {
        Map<String, Cookie> cookieMap = readCookieByMap(request);
        if (cookieMap.containsKey(cookieName)) {
            return cookieMap.get(cookieName);
        }
        return null;
    }


    public static<T> T findObject(HttpServletRequest request,String cookieName,Class<T> t){
        Cookie cookie = findCookie(cookieName, request);
        if (null == cookie) {
            return null;
        }
        String cookieStr = cookie.getValue();
        T e = JSON.parseObject(JSON.toJSONString(cookieStr),t);
        return e;
    }

    private static StringBuilder getCookieStr(CookieUnit _cookie){

        StringBuilder sb=new StringBuilder();
        sb.append(_cookie.key.trim());
        sb.append('=');
        if(!StringUtils.isEmpty(_cookie.value)){
            sb.append(_cookie.value.trim());
        }

        //--max age属性或者expires属性，两者只能选择其中一个
        if(_cookie.expires!=null){
            //--只有expires存在的情况下才能设置domain。
            sb.append("; expires=");
            //--格林威志时间格式化，注意，这是这个参数的格式要求。
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            sb.append(sdf.format(_cookie.expires));
        }else{
            sb.append("; max-age=");
            sb.append(_cookie.Max_Age);
        }
        //--domain字符串
        if(!StringUtils.isEmpty(_cookie.Domain)){
            sb.append("; domain=");
            sb.append(_cookie.Domain.trim());
        }
        //--构造path字符串
        if(!StringUtils.isEmpty(_cookie.Path)){
            sb.append("; path=");
            sb.append(_cookie.Path.trim());
        }
        //--构造secure属性
        if(_cookie.Secure){
            sb.append("; Secure");
        }
        //--构造httpOnly属性
        if(_cookie.HTTPOnly){
            sb.append("; HttpOnly");
        }
        return sb;
    }

    public String getCookiePath() {
        return cookiePath;
    }

    public void setCookiePath(String cookiePath) {
        this.cookiePath = cookiePath;
    }

    public String getUserCookie() {
        return userCookie;
    }

    public void setUserCookie(String userCookie) {
        this.userCookie = userCookie;
    }

}
