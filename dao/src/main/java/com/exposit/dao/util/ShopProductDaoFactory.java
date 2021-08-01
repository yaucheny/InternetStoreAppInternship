package com.exposit.dao.util;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.dao.daojson.ShopProductDaoJsonImpl;
import com.exposit.dao.daoxml.ShopProductDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;

@Log4j
public final class ShopProductDaoFactory implements FactoryBean<ShopProductDao> {
    @Value("${dao.serialization.config_dao_impl}")
    private String valueDao;
    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: ";

    @Override
    public ShopProductDao getObject() throws Exception {
        if (valueDao.equalsIgnoreCase("json")) {
            log.info("Get data from file category.json");
            return new ShopProductDaoJsonImpl();
        } else if (valueDao.equalsIgnoreCase("xml")) {
            log.info("Get data from file category.xml");
            return new ShopProductDaoXmlImpl();
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }

    @Override
    public Class<?> getObjectType() {
        if (valueDao.equalsIgnoreCase("json")) {
            return ShopProductDaoJsonImpl.class;
        } else if (valueDao.equalsIgnoreCase("xml")) {
            return ShopProductDaoXmlImpl.class;
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }
}
