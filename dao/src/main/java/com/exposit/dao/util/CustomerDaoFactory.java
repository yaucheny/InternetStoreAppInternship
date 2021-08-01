package com.exposit.dao.util;

import com.exposit.api.dao.CategoryDao;
import com.exposit.api.dao.CustomerDao;
import com.exposit.api.dao.StoreDao;
import com.exposit.dao.daojson.CategoryDaoJsonImpl;
import com.exposit.dao.daojson.CustomerDaoJsonImpl;
import com.exposit.dao.daoxml.CategoryDaoXmlImpl;
import com.exposit.dao.daoxml.CustomerDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Log4j
public final class CustomerDaoFactory implements FactoryBean<CustomerDao> {
    @Value("${dao.serialization.config_dao_impl}")
    private String valueDao;
    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: ";

    @Override
    public CategoryDao getObject() throws Exception {
        if (valueDao.equalsIgnoreCase("json")) {
            log.info("Get data from file category.json");
            return new CategoryDaoJsonImpl();
        } else if (valueDao.equalsIgnoreCase("xml")) {
            log.info("Get data from file category.xml");
            return new CategoryDaoXmlImpl();
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }

    @Override
    public Class<?> getObjectType() {
        if (valueDao.equalsIgnoreCase("json")) {
            return CategoryDaoJsonImpl.class;
        } else if (valueDao.equalsIgnoreCase("xml")) {
            return CategoryDaoXmlImpl.class;
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }
}
