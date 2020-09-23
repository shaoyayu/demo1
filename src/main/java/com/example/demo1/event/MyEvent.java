package com.example.demo1.event;


import org.springframework.context.ApplicationEvent;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */

public class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {
        super(source);
    }
}
