package com.exposit.dao.util;

import com.exposit.api.dao.OrderDao;
import com.exposit.dao.daohibernate.OrderDaoHiberImpl;
import com.exposit.dao.daojson.OrderDaoJsonImpl;
import com.exposit.dao.daorepository.OrderDaoRepositoryImpl;
import com.exposit.dao.daoxml.OrderDaoXmlImpl;
import com.exposit.utils.exceptions.BeanFactoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Implementation of {@link FactoryBean<OrderDao>} interface.
 * FactoryBean creates proper implementations of dao layer after receiving value
 * from application properties @see #field dao.config.
 * Input of dao in application.properties decides which implementation will be downloaded.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Configuration
@PropertySource("classpath:application.properties")
public class OrderDaoFactory implements FactoryBean<OrderDao> {

    private static final Logger LOG = LoggerFactory.getLogger(OrderDaoFactory.class);
    private String valueDao;
    private static final String GET_DAO_TYPE_ERROR_LOG = "can not find dao by property: {}";
    private static final String GET_DAO_TYPE_ERROR_EXCEPTION = "can not find dao by property: %s";

    public OrderDaoFactory(@Value("${dao.config}") String valueDao1) {
        this.valueDao = valueDao1;
    }

    @Override
    public OrderDao getObject() {
        if ("json".equalsIgnoreCase(valueDao)) {
            LOG.info("Get data from file OrderDb.json");
            return new OrderDaoJsonImpl();
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            LOG.info("Get data from file OrderDb.xml");
            return new OrderDaoXmlImpl();
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            LOG.info("Hibernate gets data from postgres database");
            return new OrderDaoHiberImpl();
        } else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            LOG.info("Spring gets data from postgres database");
            return new OrderDaoRepositoryImpl();
        }
        LOG.warn(GET_DAO_TYPE_ERROR_LOG, valueDao);
        throw new BeanFactoryException(String.format(GET_DAO_TYPE_ERROR_EXCEPTION, valueDao));
    }

    @Override
    public Class<?> getObjectType() {
        if ("json".equalsIgnoreCase(valueDao)) {
            return OrderDaoJsonImpl.class;
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            return OrderDaoXmlImpl.class;
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            return OrderDaoHiberImpl.class;
        } else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            return OrderDaoRepositoryImpl.class;
        }
        LOG.warn(GET_DAO_TYPE_ERROR_LOG, valueDao);
        throw new BeanFactoryException(String.format(GET_DAO_TYPE_ERROR_EXCEPTION, valueDao));
    }
}
