package com.exposit.dao.util;

import com.exposit.api.dao.CategoryDao;
import com.exposit.dao.daojson.CategoryDaoJsonImpl;
import com.exposit.dao.daoxml.CategoryDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Log4j
@Component
@PropertySource("classpath:application.properties")
public class CategoryDaoFactory implements FactoryBean<CategoryDao> {


    private String valueDao;

    public CategoryDaoFactory(@Value( "${dao.config}" )String valueDao) {
        this.valueDao = valueDao;
    }

    // =DaoPropertiesHandler.getProperty("config_dao_impl").orElse(null);
    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: ";

    @Override
    public CategoryDao getObject() throws Exception {
        if ("json".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file category.json");
            return new CategoryDaoJsonImpl();
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file category.xml");
            return new CategoryDaoXmlImpl();
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }

    @Override
    public Class<?> getObjectType() {
             if ("json".equalsIgnoreCase(valueDao)) {
            return CategoryDaoJsonImpl.class;
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            return CategoryDaoXmlImpl.class;}
              log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }
}
