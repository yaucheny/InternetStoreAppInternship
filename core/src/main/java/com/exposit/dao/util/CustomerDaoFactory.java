package com.exposit.dao.util;

import com.exposit.api.dao.CustomerDao;
import com.exposit.dao.daohibernate.CustomerDaoHiberImpl;
import com.exposit.dao.daojson.CustomerDaoJsonImpl;
import com.exposit.dao.daorepository.CustomerDaoRepositoryImpl;
import com.exposit.dao.daoxml.CustomerDaoXmlImpl;
import com.exposit.utils.exceptions.BeanFactoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Implementation of {@link FactoryBean<CustomerDao>} interface.
 * FactoryBean creates proper implementations of dao layer after receiving value
 * from application properties @see #field dao.config.
 * Input of dao in application.properties decides which implementation will be downloaded.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Configuration
@PropertySource("classpath:application.properties")
public class CustomerDaoFactory implements FactoryBean<CustomerDao> {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerDaoFactory.class);
    private String valueDao;
    private static final String GET_DAO_TYPE_ERROR_LOG = "can not find dao by property: {}";
    private static final String GET_DAO_TYPE_ERROR_EXCEPTION = "can not find dao by property: %s";

    public CustomerDaoFactory(@Value("${dao.config}") String valueDao1) {
        this.valueDao = valueDao1;
    }

    @Override
    public CustomerDao getObject() {
        if ("json".equalsIgnoreCase(valueDao)) {
            LOG.info("Get data from file CustomerDb.json");
            return new CustomerDaoJsonImpl();
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            LOG.info("Get data from file CustomerDb.xml");
            return new CustomerDaoXmlImpl();
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            LOG.info("Hibernate gets data from postgres database");
            return new CustomerDaoHiberImpl();
        } else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            LOG.info("Spring gets data from postgres database");
            return new CustomerDaoRepositoryImpl();
        }
        LOG.warn(GET_DAO_TYPE_ERROR_LOG, valueDao);
        throw new BeanFactoryException(String.format(GET_DAO_TYPE_ERROR_EXCEPTION, valueDao));
    }

    @Override
    public Class<?> getObjectType() {
        if ("json".equalsIgnoreCase(valueDao)) {
            return CustomerDaoJsonImpl.class;
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            return CustomerDaoXmlImpl.class;
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            return CustomerDaoHiberImpl.class;
        } else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            return CustomerDaoRepositoryImpl.class;
        }
        LOG.warn(GET_DAO_TYPE_ERROR_LOG, valueDao);
        throw new BeanFactoryException(String.format(GET_DAO_TYPE_ERROR_EXCEPTION, valueDao));
    }
}
