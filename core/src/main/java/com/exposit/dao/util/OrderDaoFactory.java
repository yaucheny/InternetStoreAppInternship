package com.exposit.dao.util;

import com.exposit.api.dao.OrderDao;
import com.exposit.dao.daohibernate.OrderDaoHiberImpl;
import com.exposit.dao.daojson.OrderDaoJsonImpl;
import com.exposit.dao.daorepository.OrderDaoRepositoryImpl;
import com.exposit.dao.daoxml.OrderDaoXmlImpl;
import com.exposit.utils.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Log4j
@Configuration
@PropertySource("classpath:application.properties")
public class OrderDaoFactory implements FactoryBean<OrderDao> {

    private String valueDao;
    private static final String GET_DAO_TYPE_ERROR_MESSAGE = "can not find dao by property: ";

    public OrderDaoFactory(@Value("${dao.config}") String valueDao) {
        this.valueDao = valueDao;
    }

    @Override
    public OrderDao getObject() throws Exception {
        if ("json".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file category.json");
            return new OrderDaoJsonImpl();
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file category.xml");
            return new OrderDaoXmlImpl();
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            log.info("Hibernate gets data from postgres database");
            return new OrderDaoHiberImpl();
        }else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            log.info("Spring gets data from postgres database");
            return new OrderDaoRepositoryImpl();
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
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
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }
}