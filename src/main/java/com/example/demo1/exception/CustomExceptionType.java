package com.example.demo1.exception;

/**
 * @author shaoyayu
 * @date 2020/9/23
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 * 错误信息响应枚举
 */
public enum CustomExceptionType {

    USER_INPUT_ERROR(400, "您输入的数据错误或您没有权限访问资源!"),
    SYSTEM_ERROR(500, "系统出现异常，请您稍后再试或联系管理员!"),
    OTHER_ERROR(999, "系统出现未知异常，请联系管理员!");

    /**
     * 错误内容
     * Error content
     */
    private String desc;

    /**
     * 错误响应码
     * Error response code
     */
    private Integer code;

    CustomExceptionType(Integer code,String desc) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getCode() {
        return code;
    }


}
