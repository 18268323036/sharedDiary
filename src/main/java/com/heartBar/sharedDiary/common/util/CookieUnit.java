package com.heartBar.sharedDiary.common.util;

import java.util.Date;

/**
 * Created by zhaox on 2017/1/8.
 */
public class CookieUnit {

    public String key="";
    public String value="";
    public int Max_Age=0;
    public String Domain="";
    public String Path="";
    public boolean Secure=false;
    public boolean HTTPOnly=false;

    /**
     * 到期时间
     * */
    public Date expires=null;

    public CookieUnit(String _key, String _value, String _domain, String _path, Date _expires, boolean _secure, boolean _httpOnly){
        key=_key;
        value=_value;
        expires=_expires;
        Domain=_domain;
        Path=_path;
        Secure=_secure;
        HTTPOnly=_httpOnly;
    }
    public CookieUnit(String _key, String _value, String _domain, String _path, int _max_age, boolean _secure, boolean _httpOnly){
        key=_key;
        value=_value;
        Max_Age=_max_age;
        Domain=_domain;
        Path=_path;
        Secure=_secure;
        HTTPOnly=_httpOnly;
    }
    public CookieUnit(String _key, String _value, int _maxAge, boolean _secure, boolean _httpOnly){
        key=_key;
        value=_value;
        Max_Age=_maxAge;
        Secure=_secure;
        HTTPOnly=_httpOnly;
    }
    public CookieUnit(String _key, String _value, Date _expires, boolean _secure, boolean _httpOnly){
        key=_key;
        value=_value;
        expires=_expires;
        Secure=_secure;
        HTTPOnly=_httpOnly;
    }

}
