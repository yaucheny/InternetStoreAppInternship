package com.exposit.dao.util;

import com.exposit.api.dao.ProductDao;
import com.exposit.dao.daojson.ProductDaoJsonImpl;
import com.exposit.dao.daoxml.ProductDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

@Log4j
@Configuration
//@PropertySource("classpath:dao.properties")
public class ProductDaoFactory implements FactoryBean<ProductDao> {

//    @Value("${config_dao_impl}")
    private String valueDao=DaoPropertiesHandler.getProperty("config_dao_impl").orElse(null);
    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: ";

    @Override
    public ProductDao getObject() throws Exception {
        if (valueDao.equalsIgnoreCase("json")) {
            log.info("Get data from file category.json");
            return new ProductDaoJsonImpl();
        } else if (valueDao.equalsIgnoreCase("xml")) {
            log.info("Get data from file category.xml");
            return new ProductDaoXmlImpl();
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }

    @Override
    public Class<?> getObjectType() {
        if (valueDao.equalsIgnoreCase("json")) {
            return ProductDaoJsonImpl.class;
        } else if (valueDao.equalsIgnoreCase("xml")) {
            return ProductDaoXmlImpl.class;
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }
}
