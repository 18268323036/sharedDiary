package com.heartBar.sharedDiary.dto;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangxy 2017/9/27 16:11
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -6469430740589692302L;

    //主键
    private Long id;
    //用户类型 1.普通用户 2.管理员
    private byte userType;
    //登录账号
    private String code;
    //登录密码
    private String password;
    //用户头像
    private String headImg;
    //姓名
    private String name;
    //性别 1.男 2.女
    private byte sex;
    //手机号
    private String mobile;
    //注册来源(1.web端 2.app端 3.微信端)
    private Byte registSource;
    //email
    private String email;
    //qq
    private String qq;
    //微信
    private String weixin;
    //微博
    private String weibo;

    private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte getUserType() {
        return userType;
    }

    public void setUserType(byte userType) {
        this.userType = userType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public Byte getRegistSource() {
        return registSource;
    }

    public void setRegistSource(Byte registSource) {
        this.registSource = registSource;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
