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

    /**
     * Returns CategoryDao implementation.
     *
     * @return Factory returns chosen dao implementation
     * @throws BeanFactoryException if needed implementation ca not be chosen
     * @author Yauheni Markevich
     */
    @Bean
    public CategoryDao categoryDao() throws BeanFactoryException {
        return categoryDaoFactory.getObject();
    }
    /**
     * Returns CategoryDao implementation.
     *
     * @return Factory returns chosen dao implementation
     * @throws BeanFactoryException if needed implementation ca not be chosen
     * @author Yauheni Markevich
     */
    @Bean
    public ProductDao productDao() throws BeanFactoryException {
        return productDaoFactory.getObject();
    }
    /**
     * Returns ShopProductDao implementation.
     *
     * @return Factory returns chosen dao implementation
     * @throws BeanFactoryException if needed implementation ca not be chosen
     * @author Yauheni Markevich
     */
    @Bean
    public ShopProductDao shopProductDao() throws BeanFactoryException {
        return shopProductDaoFactory.getObject();
    }
    /**
     * Returns OrderDao implementation.
     *
     * @return Factory returns chosen dao implementation
     * @throws BeanFactoryException if needed implementation ca not be chosen
     * @author Yauheni Markevich
     */
    @Bean
    public OrderDao orderDao() throws BeanFactoryException {
        return orderDaoFactory.getObject();
    }
    /**
     * Returns OrderItemDao implementation.
     *
     * @return Factory returns chosen dao implementation
     * @throws BeanFactoryException if needed implementation ca not be chosen
     * @author Yauheni Markevich
     */
    @Bean
    public OrderItemDao orderItemDao() throws BeanFactoryException {
        return orderItemDaoFactory.getObject();
    }
    /**
     * Returns StoreDao implementation.
     *
     * @return Factory returns chosen dao implementation
     * @throws BeanFactoryException if needed implementation ca not be chosen
     * @author Yauheni Markevich
     */
    @Bean
    public StoreDao storeDao() throws BeanFactoryException {
        return storeDaoFactory.getObject();
    }
    /**
     * Returns CustomerDa implementation.
     *
     * @return Factory returns chosen dao implementation
     * @throws BeanFactoryException if needed implementation ca not be chosen
     * @author Yauheni Markevich
     */
    @Bean
    public CustomerDao customerDao() throws BeanFactoryException {
        return customerDaoFactory.getObject();
    }
}
