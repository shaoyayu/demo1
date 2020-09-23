package com.example.demo1.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
@Configuration
public class FilterRegistration {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new CustomFilter());
        filterRegistration.setName("filterRegistrationBean");
        filterRegistration.addUrlPatterns("/*");
        //设置拦截器的权值，权值越小，执行顺序越靠前面
        filterRegistration.setOrder(10);
        return filterRegistration;
    }

}
