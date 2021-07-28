package com.exposit.dao.config;

import com.exposit.api.dao.*;
import com.exposit.dto.ShopProductDto;
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
        return beanFactory.getBean("categoryDaoJson", CategoryDao.class);
    }

    @Bean
    @Primary
    public ProductDao productDao() {
        return beanFactory.getBean("productDaoJson", ProductDao.class);
    }

    @Bean
    @Primary
    public ShopProductDao shopProductDao() {
        return beanFactory.getBean("shopProduct", ShopProductDao.class);
    }

    @Bean
    @Primary
    public OrderDao orderDao() {
        return beanFactory.getBean("orderDaoJson", OrderDao.class);
    }

    @Bean
    @Primary
    public OrderItemDao orderItemDao() {
        return beanFactory.getBean("orderItemDaoJson", OrderItemDao.class);
    }

    @Bean
    @Primary
    public StoreDao storeDao() {
        return beanFactory.getBean("storeDaoJson", StoreDao.class);
    }

    @Bean
    @Primary
    public CustomerDao customerDao() {
        return beanFactory.getBean("customerDaoJson", CustomerDao.class);
    }
}
