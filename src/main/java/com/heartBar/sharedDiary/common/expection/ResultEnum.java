package com.heartBar.sharedDiary.common.expection;

/**
 * @author zhangxy 2017/9/26 15:41
 */
public enum  ResultEnum {

    PARAM_ERROR(100,"参数校验错误"),


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
