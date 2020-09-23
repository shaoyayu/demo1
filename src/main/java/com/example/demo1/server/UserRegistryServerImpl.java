package com.example.demo1.server;

import com.example.demo1.dao.test.repository.TestUserRegistryRepository;
import com.example.demo1.dao.test.model.UseRegistry;
import com.example.demo1.dao.users.repository.UserUserRegistryRepository;
import com.example.demo1.exception.CustomException;
import com.example.demo1.exception.CustomExceptionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
@Service
@Slf4j
public class UserRegistryServerImpl implements UserRegistryServer {

    @Resource
    private TestUserRegistryRepository registryRepository;

    @Resource
    private UserUserRegistryRepository userUserRegistryRepository;

    /**
     * 双数据源事务
     * @param useRegistry
     * @return
     */
    @Override
    @Transactional
    public boolean saveUser(UseRegistry useRegistry) {
        UseRegistry useRegistry1 = registryRepository.save(useRegistry);
        UseRegistry useRegistry2 = userUserRegistryRepository.save(useRegistry);
        log.info(useRegistry1.toString() + "," + useRegistry2.toString());
        return true;
    }

    @Override
    public boolean deleteUsers(int t) {

        if (t==0){
            try {
                Class.forName("sssss");
            } catch (ClassNotFoundException e) {
                log.info(e.getMessage());
                throw new CustomException(CustomExceptionType.SYSTEM_ERROR,
                        getClass().getPackage()+getClass().getName()+"deleteUsers() 启动扫描异常");
            }
        }
        return true;

    }
}
