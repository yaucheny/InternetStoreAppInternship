package com.exposit.dao.config;

import com.exposit.api.dao.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigDao {

    @Value("$(dao.serialization.config_dao_impl)")
    private String valueDao;


    @Autowired
    private BeanFactory beanFactory;

    @Bean
    @Primary
    public CategoryDao categoryDao() {
        return beanFactory.getBean("categoryJson", CategoryDao.class);
    }

    @Bean
    @Primary
    public ProductDao productDao() {
        return beanFactory.getBean("productJson", ProductDao.class);
    }

    @Bean
    @Primary
    public ShopProductDao shopProductDao() {
        return beanFactory.getBean("shopProductJson", ShopProductDao.class);
    }

    @Bean
    @Primary
    public OrderDao orderDao() {
        return beanFactory.getBean("orderJson", OrderDao.class);
    }

    @Bean
    @Primary
    public OrderItemDao orderItemDao() {
        return beanFactory.getBean("orderItemJson", OrderItemDao.class);
    }

    @Bean
    @Primary
    public StoreDao storeDao() {
        return beanFactory.getBean("storeJson", StoreDao.class);
    }

    @Bean
    @Primary
    public CustomerDao customerDao() {
        return beanFactory.getBean("customerJson", CustomerDao.class);
    }
}
