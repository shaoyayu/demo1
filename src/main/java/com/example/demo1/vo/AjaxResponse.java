package com.example.demo1.vo;

import com.example.demo1.exception.CustomException;
import com.example.demo1.exception.CustomExceptionType;
import lombok.Data;

/**
 * @author shaoyayu
 * @date 2020/9/23
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
@Data
public class AjaxResponse {
    /**
     * 请求是否处理成功
     */
    private boolean isok;
    /**
     * 请求响应状态码（200、400、500）
     */
    private int code;
    /**
     * 请求结果描述信息
     */
    private String message;
    /**
     * 请求结果数据（通常用于查询操作）
     */
    private Object data;


    public AjaxResponse() {
    }

    /**
     * 请求成功的响应信息
     * @return
     */
    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        return ajaxResponse;
    }

    /**
     * 请求成功，附带查询信息
     * @param obj
     * @return
     */
    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok( true);
        ajaxResponse.setCode (200);
        ajaxResponse. setMessage("请求响应成功!");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    /**
     * 获取到数据附带请求的信息
     * @param obj
     * @param message
     * @return
     */
    public static AjaxResponse success(Object obj,String message){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse. setIsok( true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    /**
     * 异常信息封装的处理结构
     * @param e
     * @return
     */
    public static AjaxResponse error(CustomException e) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(false);
        resultBean.setCode(e.getCode());
        resultBean.setMessage(e.getMessage());
        return resultBean;
    }

    /**
     * 错误信息自定义
     * @param customExceptionType
     * @param errorMessage
     * @return
     */
    public static AjaxResponse error(CustomExceptionType customExceptionType,
                                     String errorMessage){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok( false);
        resultBean.setCode(customExceptionType.getCode());
        resultBean.setMessage(errorMessage);
        return resultBean;
    }



}
