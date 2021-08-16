package com.exposit.dao.config;


import com.exposit.api.dao.*;
import com.exposit.dao.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDao {

    @Autowired
    private CategoryDaoFactory categoryDaoFactory;
    @Autowired
    private CustomerDaoFactory customerDaoFactory;
    @Autowired
    private ProductDaoFactory productDaoFactory;
    @Autowired
    private ShopProductDaoFactory shopProductDaoFactory;
    @Autowired
    private OrderDaoFactory orderDaoFactory;
    @Autowired
    private OrderItemDaoFactory orderItemDaoFactory;
    @Autowired
    private StoreDaoFactory storeDaoFactory;

    @Bean
    public CategoryDao categoryDao() throws Exception {
        return categoryDaoFactory.getObject();
    }

    @Bean
    public ProductDao productDao() throws Exception {
        return productDaoFactory.getObject();
    }

    @Bean
    public ShopProductDao shopProductDao() throws Exception {
        return shopProductDaoFactory.getObject();
    }

    @Bean
    public OrderDao orderDao() throws Exception {
        return orderDaoFactory.getObject();
    }

    @Bean
    public OrderItemDao orderItemDao() throws Exception {
        return orderItemDaoFactory.getObject();
    }

    @Bean
    public StoreDao storeDao() throws Exception {
        return storeDaoFactory.getObject();
    }

    @Bean
    public CustomerDao customerDao() throws Exception {
        return customerDaoFactory.getObject();
    }
}
