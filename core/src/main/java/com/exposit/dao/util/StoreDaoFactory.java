package com.exposit.dao.util;

import com.exposit.api.dao.StoreDao;
import com.exposit.dao.daohibernate.StoreDaoHiberImpl;
import com.exposit.dao.daojson.StoreDaoJsonImpl;
import com.exposit.dao.daorepository.StoreDaoRepositoryImpl;
import com.exposit.dao.daoxml.StoreDaoXmlImpl;
import com.exposit.utils.exceptions.BeanFactoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Implementation of {@link FactoryBean<StoreDao>} interface.
 * FactoryBean creates proper implementations of dao layer after receiving value
 * from application properties @see #field dao.config.
 * Input of dao in application.properties decides which implementation will be downloaded.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Configuration
@PropertySource("classpath:application.properties")
public class StoreDaoFactory implements FactoryBean<StoreDao> {
    private static final Logger LOG = LoggerFactory.getLogger(StoreDaoFactory.class);
    private String valueDao;
    private static final String GET_DAO_TYPE_ERROR_LOG = "can not find dao by property: {}";
    private static final String GET_DAO_TYPE_ERROR_EXCEPTION = "can not find dao by property: %s";

    public StoreDaoFactory(@Value("${dao.config}") String valueDao1) {
        this.valueDao = valueDao1;
    }

    @Override
    public StoreDao getObject() {
        if ("json".equalsIgnoreCase(valueDao)) {
            LOG.info("Get data from file StoreDb.json");
            return new StoreDaoJsonImpl();
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            LOG.info("Get data from file StoreDb.xml");
            return new StoreDaoXmlImpl();
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            LOG.info("Hibernate gets data from postgres database");
            return new StoreDaoHiberImpl();
        } else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            LOG.info("Spring gets data from postgres database");
            return new StoreDaoRepositoryImpl();
        }
        LOG.warn(GET_DAO_TYPE_ERROR_LOG, valueDao);
        throw new BeanFactoryException(String.format(GET_DAO_TYPE_ERROR_EXCEPTION, valueDao));
    }

    @Override
    public Class<?> getObjectType() {
        if ("json".equalsIgnoreCase(valueDao)) {
            return StoreDaoJsonImpl.class;
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            return StoreDaoXmlImpl.class;
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            return StoreDaoHiberImpl.class;
        } else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            return StoreDaoRepositoryImpl.class;
        }
        LOG.warn(GET_DAO_TYPE_ERROR_LOG, valueDao);
        throw new BeanFactoryException(String.format(GET_DAO_TYPE_ERROR_EXCEPTION, valueDao));
    }
}
