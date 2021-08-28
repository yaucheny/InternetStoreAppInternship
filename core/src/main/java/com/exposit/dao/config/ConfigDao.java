package com.exposit.dao.config;


import com.exposit.api.dao.*;
import com.exposit.dao.util.*;
import com.exposit.utils.exceptions.BeanFactoryException;
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
    public CategoryDao categoryDao() throws BeanFactoryException {
        return categoryDaoFactory.getObject();
    }

    @Bean
    public ProductDao productDao() throws BeanFactoryException {
        return productDaoFactory.getObject();
    }

    @Bean
    public ShopProductDao shopProductDao() throws BeanFactoryException {
        return shopProductDaoFactory.getObject();
    }

    @Bean
    public OrderDao orderDao() throws BeanFactoryException {
        return orderDaoFactory.getObject();
    }

    @Bean
    public OrderItemDao orderItemDao() throws BeanFactoryException {
        return orderItemDaoFactory.getObject();
    }

    @Bean
    public StoreDao storeDao() throws BeanFactoryException {
        return storeDaoFactory.getObject();
    }

    @Bean
    public CustomerDao customerDao() throws BeanFactoryException {
        return customerDaoFactory.getObject();
    }
}
