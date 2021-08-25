package com.exposit.dao.util;

import com.exposit.api.dao.CustomerDao;
import com.exposit.dao.daohibernate.CustomerDaoHiberImpl;
import com.exposit.dao.daojson.CustomerDaoJsonImpl;
import com.exposit.dao.daorepository.CustomerDaoRepositoryImpl;
import com.exposit.dao.daoxml.CustomerDaoXmlImpl;
import com.exposit.utils.exceptions.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application.properties")
public class CustomerDaoFactory implements FactoryBean<CustomerDao> {

    private final static Logger log = LoggerFactory.getLogger(CustomerDaoFactory.class);
    private String valueDao;
    private static final String GET_DAO_TYPE_ERROR_MESSAGE = "can not find dao by property: ";

    public CustomerDaoFactory(@Value("${dao.config}") String valueDao) {
        this.valueDao = valueDao;
    }

    @Override
    public CustomerDao getObject() throws Exception {
        if ("json".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file CustomerDb.json");
            return new CustomerDaoJsonImpl();
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file CustomerDb.xml");
            return new CustomerDaoXmlImpl();
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            log.info("Hibernate gets data from postgres database");
            return new CustomerDaoHiberImpl();
        }else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            log.info("Spring gets data from postgres database");
            return new CustomerDaoRepositoryImpl();
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
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            return CustomerDaoHiberImpl.class;
        } else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            return CustomerDaoRepositoryImpl.class;
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }
}
