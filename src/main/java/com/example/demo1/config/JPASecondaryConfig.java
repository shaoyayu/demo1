package com.example.demo1.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
@Configuration
@DependsOn("transactionManager")
@EnableJpaRepositories(basePackages = "com.example.demo1.dao.users",
        entityManagerFactoryRef = "secondaryEntityManager",
        transactionManagerRef = "transactionManager")
public class JPASecondaryConfig {
    @Resource
    private JpaVendorAdapter jpaVendorAdapter;

    @Bean(name = "secondaryDataSourceProperties")
    @ConfigurationProperties(prefix ="spring.datasource.secondary")
    public DataSourceProperties masterDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "secondaryDataSource", initMethod ="init",destroyMethod = "close")
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSource secondaryDataSource() throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(masterDataSourceProperties().getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(masterDataSourceProperties().getPassword());
        mysqlXaDataSource.setUser(masterDataSourceProperties().getUsername());
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource. setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName( "secondary");
        xaDataSource.setBorrowConnectionTimeout (60);
        xaDataSource.setMaxPoolSize(20);
        return xaDataSource;
    }

    @Bean(name = "secondaryEntityManager")
    @DependsOn( "transactionManager")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManager() throws Throwable {
        HashMap<String,Object> properties = new HashMap<String, Object>();
        properties.put("javax.persistence.transactionType","JTA");
        properties.put("hibernate.transaction.jta.platform",AtomikosJtaPlatform.class.getName());
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(secondaryDataSource());
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        entityManager.setPackagesToScan("com.example.demo1.dao.test");
        entityManager.setPersistenceUnitName("secondaryPersistenceUnit");
        //这里要修政成主数据源的扫描包
        entityManager.setJpaPropertyMap(properties);
        return entityManager;
    }
}
