package com.example.demo1.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
//@WebFilter(filterName = "customFilter",urlPatterns = "/*")
@Slf4j
public class CustomFilter implements Filter {

    ////这种过滤器无法保证过滤器的执行顺序,按照的是字母的顺序执行的

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter init ......");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Request filter custom .....");
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.setCharacterEncoding("UTF-8");
    }

    @Override
    public void destroy() {
        log.info("filter destroy .....");
    }
}
