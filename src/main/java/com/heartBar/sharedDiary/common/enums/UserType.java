package com.heartBar.sharedDiary.common.enums;

/**
 * @author zhangxy 2017/9/28
 */
public enum UserType {

    COMMON_USER((byte)1,"COMMON"),
    MANAGE_USER((byte)2,"MANAGE"),
    ;

    UserType(Byte code,String name){
        this.code = code;
        this.name = name;
    }

    private Byte code;
    private String name;

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
