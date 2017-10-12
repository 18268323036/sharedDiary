package com.heartBar.sharedDiary.common.expection;

/**
 * @author zhangxy 2017/9/26 15:41
 */
public enum  ResultEnum {
    SUCCESS(1,"成功"),

    PARAM_ERROR(100,"参数校验错误"),
    REGIST_FILED(101,"注册失败"),
    MOBILE_FORMAT_ERROR(102,"手机号码格式校验错误"),
    MOBILE_HASNOT_REGIST(103,"手机号码尚未注册"),
    PASSWORD_ERROR(104,"密码不正确"),
    NO_DATA_ERROR(105,"没有相关数据"),
    ADD_ERROR(106,"添加失败"),

    MOBILE_HAS_REGISTERED(110,"手机号码已经注册"),
    ;

    private int code;
    private String message;

    ResultEnum(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
