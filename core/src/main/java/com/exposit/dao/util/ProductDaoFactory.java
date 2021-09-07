package com.exposit.dao.util;

import com.exposit.api.dao.ProductDao;
import com.exposit.dao.daohibernate.ProductDaoHiberImpl;
import com.exposit.dao.daojson.ProductDaoJsonImpl;
import com.exposit.dao.daorepository.ProductDaoRepositoryImpl;
import com.exposit.dao.daoxml.ProductDaoXmlImpl;
import com.exposit.utils.exceptions.BeanFactoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Implementation of {@link FactoryBean<ProductDao>} interface.
 * FactoryBean creates proper implementations of dao layer after receiving value
 * from application properties @see #field dao.config.
 * Input of dao in application.properties decides which implementation will be downloaded.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ProductDaoFactory implements FactoryBean<ProductDao> {

    private static final Logger LOG = LoggerFactory.getLogger(ProductDaoFactory.class);
    private String valueDao;
    private static final String GET_DAO_TYPE_ERROR_LOG = "can not find dao by property: {}";
    private static final String GET_DAO_TYPE_ERROR_EXCEPTION = "can not find dao by property: %s";

    public ProductDaoFactory(@Value("${dao.config}") String valueDao1) {
        this.valueDao = valueDao1;
    }

    @Override
    public ProductDao getObject() {
        if ("json".equalsIgnoreCase(valueDao)) {
            LOG.info("Get data from file ProductDb.json");
            return new ProductDaoJsonImpl();
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            LOG.info("Get data from file ProductDb.xml");
            return new ProductDaoXmlImpl();
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            LOG.info("Hibernate gets data from postgres database");
            return new ProductDaoHiberImpl();
        } else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            LOG.info("Spring gets data from postgres database");
            return new ProductDaoRepositoryImpl();
        }
        LOG.warn(GET_DAO_TYPE_ERROR_LOG, valueDao);
        throw new BeanFactoryException(String.format(GET_DAO_TYPE_ERROR_EXCEPTION, valueDao));
    }

    @Override
    public Class<?> getObjectType() {
        if ("json".equalsIgnoreCase(valueDao)) {
            return ProductDaoJsonImpl.class;
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            return ProductDaoXmlImpl.class;
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            return ProductDaoHiberImpl.class;
        } else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            return ProductDaoRepositoryImpl.class;
        }
        LOG.warn(GET_DAO_TYPE_ERROR_LOG, valueDao);
        throw new BeanFactoryException(String.format(GET_DAO_TYPE_ERROR_EXCEPTION, valueDao));
    }
}
