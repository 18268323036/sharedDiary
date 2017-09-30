package com.heartBar.sharedDiary.common.enums;

/**
 * @author zhangxy 2017/9/29
 */
public enum SexEnum {

    MALE((byte)1,"男"),
    FEMALE((byte)2,"女"),
    ;


    private Byte code;
    private String name;

    SexEnum(Byte code,String name){
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }
}
