package com.example.demo1.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
@Slf4j
@Component
public class LoggerEvent implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        log.info(""+myEvent.getSource());
    }
}
