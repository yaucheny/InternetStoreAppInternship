package com.exposit.dao.config;


import com.exposit.api.dao.CategoryDao;
import com.exposit.api.dao.ProductDao;
import com.exposit.api.dao.CustomerDao;
import com.exposit.api.dao.StoreDao;
import com.exposit.api.dao.OrderItemDao;
import com.exposit.api.dao.OrderDao;
import com.exposit.api.dao.ShopProductDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dao.properties")
public class ConfigDao {

//    @Value("${dao.serialization.config_dao_impl}")
    private String valueDao;


    @Autowired
    private BeanFactory beanFactory;

    @Bean
    @Primary
    public CategoryDao categoryDao() {
        return beanFactory.getBean("category" + valueDao, CategoryDao.class);
    }

    @Bean
    @Primary
    public ProductDao productDao() {
        return beanFactory.getBean("product" + valueDao, ProductDao.class);
    }

    @Bean
    @Primary
    public ShopProductDao shopProductDao() {
        return beanFactory.getBean("shopProduct" + valueDao, ShopProductDao.class);
    }

    @Bean
    @Primary
    public OrderDao orderDao() {
        return beanFactory.getBean("order" + valueDao, OrderDao.class);
    }

    @Bean
    @Primary
    public OrderItemDao orderItemDao() {
        return beanFactory.getBean("orderItem" + valueDao, OrderItemDao.class);
    }

    @Bean
    @Primary
    public StoreDao storeDao() {
        return beanFactory.getBean("store" + valueDao, StoreDao.class);
    }

    @Bean
    @Primary
    public CustomerDao customerDao() {
        return beanFactory.getBean("customer" + valueDao, CustomerDao.class);
    }
}
