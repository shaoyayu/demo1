package com.example.demo1.server;

import com.example.demo1.dao.test.model.UseRegistry;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
public interface UserRegistryServer {

    /**
     * 注册一个用户
     * @param useRegistry
     * @return
     */
    boolean saveUser(UseRegistry useRegistry);

    /**
     * 删除一个用户
     * @return
     * @param t
     */
    boolean deleteUsers(int t);
}
