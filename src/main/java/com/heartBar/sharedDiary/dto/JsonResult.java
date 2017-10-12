package com.heartBar.sharedDiary.dto;

import com.heartBar.sharedDiary.common.expection.ResultEnum;
import com.heartBar.sharedDiary.common.expection.ValidException;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangxy 2017/9/28 15:17
 */
public class JsonResult <T> implements Serializable {

    private int code;

    private String message;

    private T t;

    private List<T> list;

    public JsonResult() {
    }

    public JsonResult(int code, String message, T t, List<T> list) {
        this.code = code;
        this.message = message;
        this.t = t;
        this.list = list;
    }

    public JsonResult(int code, String message, T t) {
        this.code = code;
        this.message = message;
        this.t = t;
    }


    public JsonResult(int code, String message, List<T> list) {
        this.code = code;
        this.message = message;
        this.list = list;
    }

    public JsonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonResult(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }


    public JsonResult(ResultEnum resultEnum,T t) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.t = t;
    }


    public static JsonResult getJsonObj(ResultEnum resultEnum, String... messages) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.code = resultEnum.getCode();
        jsonResult.message = resultEnum.getMessage();
        return jsonResult;
    }

    public static JsonResult getJsonObj(int code, String message) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.code = code;
        jsonResult.message = message;
        return jsonResult;
    }

    public static JsonResult validExceptionConvert(ValidException validException){
        JsonResult jsonResult = new JsonResult();
        jsonResult.code = validException.getErrorCode();
        jsonResult.message = validException.getMessage();
        return jsonResult;
    }

    public static JsonResult getOkJsonObj(List<?> list) {
        return new JsonResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), list);
    }

    public static JsonResult getOkJsonObj(Object object) {
        return new JsonResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), object);
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

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


    //====================== jQuery validform ajax远程验证使用===================

    private String status;

    private String info;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static JsonResult checkResult(String status, String info) {
        JsonResult json = new JsonResult();
        json.setStatus(status);
        json.setInfo(info);
        return json;
    }
}
