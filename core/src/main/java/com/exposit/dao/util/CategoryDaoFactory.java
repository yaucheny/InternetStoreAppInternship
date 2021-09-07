package com.exposit.dao.util;

import com.exposit.api.dao.CategoryDao;
import com.exposit.dao.daohibernate.CategoryDaoHiberImpl;
import com.exposit.dao.daojson.CategoryDaoJsonImpl;
import com.exposit.dao.daorepository.CategoryDaoRepositoryImpl;
import com.exposit.dao.daoxml.CategoryDaoXmlImpl;
import com.exposit.utils.exceptions.BeanFactoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link FactoryBean<CategoryDao>} interface.
 * FactoryBean creates proper implementations of dao layer after receiving value
 * from application properties @see #field dao.config.
 * Input of dao in application.properties decides which implementation will be downloaded.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Component
@PropertySource("classpath:application.properties")
public class CategoryDaoFactory implements FactoryBean<CategoryDao> {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryDaoFactory.class);
    private String valueDao;
    private static final String GET_DAO_TYPE_ERROR_LOG = "can not find dao by property: {}";
    private static final String GET_DAO_TYPE_ERROR_EXCEPTION = "can not find dao by property: %s";

    public CategoryDaoFactory(@Value("${dao.config}") String valueDao1) {
        this.valueDao = valueDao1;
    }

    @Override
    public CategoryDao getObject() {
        if ("json".equalsIgnoreCase(valueDao)) {
            LOG.info("Get data from file CategoryDb.json");
            return new CategoryDaoJsonImpl();
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            LOG.info("Get data from file CategoryDb.xml");
            return new CategoryDaoXmlImpl();
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            LOG.info("Hibernate gets data from postgres database");
            return new CategoryDaoHiberImpl();
        } else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            LOG.info("Spring gets data from postgres database");
            return new CategoryDaoRepositoryImpl();
        }
        LOG.warn(GET_DAO_TYPE_ERROR_LOG, valueDao);
        throw new BeanFactoryException(String.format(GET_DAO_TYPE_ERROR_EXCEPTION, valueDao));
    }

    @Override
    public Class<?> getObjectType() {
        if ("json".equalsIgnoreCase(valueDao)) {
            return CategoryDaoJsonImpl.class;
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            return CategoryDaoXmlImpl.class;
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            return CategoryDaoHiberImpl.class;
        } else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            return CategoryDaoRepositoryImpl.class;
        }
        LOG.warn(GET_DAO_TYPE_ERROR_LOG, valueDao);
        throw new BeanFactoryException(String.format(GET_DAO_TYPE_ERROR_EXCEPTION, valueDao));
    }
}
