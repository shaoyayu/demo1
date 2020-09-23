package com.example.demo1.exception;

import com.example.demo1.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaoyayu
 * @date 2020/9/23
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
@Slf4j
@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse customerException(CustomException e) {
        if (!e.getCode().equals(CustomExceptionType.USER_INPUT_ERROR.getCode())){
            //TODO 把系统级别的错误信息持久化
            log.error(e.getMessage(),e.getCause());
        }
        return AjaxResponse.error(e);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResponse customerException(Exception e){
        //TODO 需要把错误信息持久化
        log.error(e.getMessage(),e.getCause());
        return AjaxResponse.error(new CustomException(CustomExceptionType.OTHER_ERROR));
    }

}
