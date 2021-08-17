package com.exposit.dao.util;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.dao.daohibernate.ShopProductDaoHiberImpl;
import com.exposit.dao.daojson.ShopProductDaoJsonImpl;
import com.exposit.dao.daorepository.ShopProductDaoRepositoryImpl;
import com.exposit.dao.daoxml.ShopProductDaoXmlImpl;
import com.exposit.utils.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Log4j
@Configuration
@PropertySource("classpath:application.properties")
public class ShopProductDaoFactory implements FactoryBean<ShopProductDao> {

    private String valueDao;
    private static final String GET_DAO_TYPE_ERROR_MESSAGE = "can not find dao by property: ";

    public ShopProductDaoFactory(@Value("${dao.config}") String valueDao) {
        this.valueDao = valueDao;
    }

    @Override
    public ShopProductDao getObject() throws Exception {
        if ("json".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file category.json");
            return new ShopProductDaoJsonImpl();
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            log.info("Get data from file category.xml");
            return new ShopProductDaoXmlImpl();
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            log.info("Hibernate gets data from postgres database");
            return new ShopProductDaoHiberImpl();
        }else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            log.info("Spring gets data from postgres database");
            return new ShopProductDaoRepositoryImpl();
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }

    @Override
    public Class<?> getObjectType() {
        if ("json".equalsIgnoreCase(valueDao)) {
            return ShopProductDaoJsonImpl.class;
        } else if ("xml".equalsIgnoreCase(valueDao)) {
            return ShopProductDaoXmlImpl.class;
        } else if ("hibernate".equalsIgnoreCase(valueDao)) {
            return ShopProductDaoHiberImpl.class;
        } else if ("jpa-repository".equalsIgnoreCase(valueDao)) {
            return ShopProductDaoRepositoryImpl.class;
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }
}