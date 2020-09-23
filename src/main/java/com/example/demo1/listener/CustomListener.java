package com.example.demo1.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
@Slf4j
@WebListener
public class CustomListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("--contextInitialized()");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("--contextDestroyed()");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        log.info("--requestInitialized()"+request.getRequestURI());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        log.info("--requestDestroyed()"+request.getRequestURI());
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("--sessionCreated()"+se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("--sessionDestroyed()"+se.getSession().getId());
    }
}
