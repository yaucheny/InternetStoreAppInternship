package com.exposit.dao.util;

import com.exposit.api.dao.StoreDao;
import com.exposit.dao.daohibernate.StoreDaoHiberImpl;
import com.exposit.dao.daojson.StoreDaoJsonImpl;
import com.exposit.dao.daoxml.StoreDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Log4j
@Configuration
@PropertySource("classpath:application.properties")
public class StoreDaoFactory implements FactoryBean<StoreDao> {

    private String valueDao;
    private static final String GET_DAO_TYPE_ERROR_MESSAGE = "can not find dao by property: ";

    public StoreDaoFactory(@Value("${dao.config}") String valueDao) {
        this.valueDao = valueDao;
    }

    @Override
    public StoreDao getObject() throws Exception {
        if ("json".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file category.json");
            return new StoreDaoJsonImpl();
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file category.xml");
            return new StoreDaoXmlImpl();
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            log.info("Get data from postgres database");
            return new StoreDaoHiberImpl();
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }

    @Override
    public Class<?> getObjectType() {
        if ("json".equalsIgnoreCase(valueDao)) {
            return StoreDaoJsonImpl.class;
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            return StoreDaoXmlImpl.class;
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            return StoreDaoHiberImpl.class;
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }
}
