package com.example.demo1.controller;

import com.example.demo1.dao.test.model.UseRegistry;
import com.example.demo1.event.MyEvent;
import com.example.demo1.server.UserRegistryServer;
import com.example.demo1.vo.CurrentVo;
import com.example.demo1.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.security.auth.login.AppConfigurationEntry;
import java.sql.Timestamp;
import java.util.Currency;
import java.util.Date;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserRegistryServer userRegistryServer;

    @Resource
    ApplicationContext applicationContext;

    @PostMapping(value = "/{email}")
    public CurrentVo saveUser(@PathVariable String email,String password){
        log.debug(email+","+password);
        UseRegistry useRegistry = new UseRegistry();
        useRegistry.setEmail(email);
        Date date = new Date();
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);
        useRegistry.setCanLogin(1);
        useRegistry.setrTime(timestamp);
        useRegistry.setPassword(password);
        log.info(useRegistry.toString());
        if (userRegistryServer.saveUser(useRegistry)){
            CurrentVo currentVo = new CurrentVo(200,"1","添加用户成功");
            return currentVo;
        }else {
            CurrentVo currentVo = new CurrentVo(200,"0","添加用户失败");
            return currentVo;
        }
    }

    @GetMapping("/{email}")
    public CurrentVo hello(@PathVariable String email){
        CurrentVo currentVo = new CurrentVo(200,"1","请求成功"+email);
        applicationContext.publishEvent(new MyEvent(email+"请求登录"));
        return currentVo;
    }

    @DeleteMapping("/{email}")
    public UserVo deleteUsers(@PathVariable String email){
        userRegistryServer.deleteUsers(1);
        return new UserVo(email,2);
    }

}
