package com.exposit.dao.config;


import com.exposit.api.dao.*;
import com.exposit.dao.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class ConfigDao {


    private final CategoryDaoFactory categoryDaoFactory;
    private final CustomerDaoFactory customerDaoFactory;
    private final ProductDaoFactory productDaoFactory;
    private final ShopProductDaoFactory shopProductDaoFactory;
    private final OrderDaoFactory orderDaoFactory;
    private final OrderItemDaoFactory orderItemDaoFactory;
    private final StoreDaoFactory storeDaoFactory;

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
