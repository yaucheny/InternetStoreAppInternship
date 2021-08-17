package com.exposit.dao.util;

import com.exposit.api.dao.CategoryDao;
import com.exposit.dao.daohibernate.CategoryDaoHiberImpl;
import com.exposit.dao.daojson.CategoryDaoJsonImpl;
import com.exposit.dao.daorepository.CategoryDaoRepositoryImpl;
import com.exposit.dao.daoxml.CategoryDaoXmlImpl;
import com.exposit.utils.exceptions.DaoException;
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
    private static final String GET_DAO_TYPE_ERROR_MESSAGE = "can not find dao by property: ";

    public CategoryDaoFactory(@Value("${dao.config}") String valueDao) {
        this.valueDao = valueDao;
    }

    @Override
    public CategoryDao getObject() throws Exception {
        if ("json".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file category.json");
            return new CategoryDaoJsonImpl();
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file category.xml");
            return new CategoryDaoXmlImpl();
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            log.info("Hibernate gets data from postgres database");
            return new CategoryDaoHiberImpl();
        }else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            log.info("Spring gets data from postgres database");
            return new CategoryDaoRepositoryImpl();
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
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
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }
}
