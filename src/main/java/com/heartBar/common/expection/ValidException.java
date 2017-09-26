package com.heartBar.common.expection;

/**
 * @author zhangxy 2017/9/26 14:52
 */
public class ValidException extends RuntimeException{

    private int errorCode;

    private String errorMessage;

    public ValidException(String message, int errorCode, String errorMessage){
        super(message);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ValidException(String message,int errorCode,String errorMessage,Throwable e){
        super(message,e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ValidException(ResultEnum paramError) {
        super(paramError.getMessage());
        this.errorCode = paramError.getCode();
        this.errorMessage = paramError.getMessage();
    }

    public static ValidException errorCodeTable(String message, int code, String errorMessage) {
        return new ValidException(message, code, errorMessage);
    }

    public static ValidException errorCodeTable(String message, int code, String errorMessage, Throwable e){
        return new ValidException(message, code, errorMessage,e);
    }

    public static ValidException errorCodeTable(String message, ResultEnum resultEnum, Throwable e){
        return new ValidException(message, resultEnum.getCode(), resultEnum.getMessage(),e);
    }

    public static ValidException errorCodeTable(ResultEnum resultEnum, Throwable e){
        return new ValidException(resultEnum.getMessage(), resultEnum.getCode(), resultEnum.getMessage(),e);
    }

    public static ValidException errorCodeTable(ResultEnum resultEnum){
        return new ValidException(resultEnum.getMessage(), resultEnum.getCode(), resultEnum.getMessage());
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
