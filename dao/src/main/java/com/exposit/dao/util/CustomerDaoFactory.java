package com.exposit.dao.util;

import com.exposit.api.dao.CustomerDao;
import com.exposit.dao.daojson.CustomerDaoJsonImpl;
import com.exposit.dao.daoxml.CustomerDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Log4j
@Configuration
@PropertySource("classpath:application.properties")
public class CustomerDaoFactory implements FactoryBean<CustomerDao> {

    private String valueDao;
    private static final String GET_DAO_TYPE_ERROR_MESSAGE = "can not find dao by property: ";

    public CustomerDaoFactory(@Value("${dao.config}") String valueDao) {
        this.valueDao = valueDao;
    }

    @Override
    public CustomerDao getObject() throws Exception {
        if ("json".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file category.json");
            return new CustomerDaoJsonImpl();
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file category.xml");
            return new CustomerDaoXmlImpl();
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }

    @Override
    public Class<?> getObjectType() {
        if ("json".equalsIgnoreCase(valueDao)) {
            return CustomerDaoJsonImpl.class;
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            return CustomerDaoXmlImpl.class;
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }
}
