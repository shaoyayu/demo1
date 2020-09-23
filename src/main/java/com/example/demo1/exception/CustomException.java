package com.example.demo1.exception;

/**
 * @author shaoyayu
 * @date 2020/9/23
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
public class CustomException extends RuntimeException {

    private Integer code;

    private String message;

    private CustomException() {

    }

    public CustomException(CustomExceptionType exceptionTypeEnum) {
        this.code = exceptionTypeEnum.getCode();
        this.message = exceptionTypeEnum.getDesc();
    }

    public CustomException(CustomExceptionType exceptionTypeEnum,
                           String message){
        this.code =exceptionTypeEnum.getCode();
        this.message =message;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
