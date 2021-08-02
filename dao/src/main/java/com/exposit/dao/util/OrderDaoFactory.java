package com.exposit.dao.util;

import com.exposit.api.dao.OrderDao;
import com.exposit.dao.daojson.OrderDaoJsonImpl;
import com.exposit.dao.daoxml.OrderDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

@Log4j
@Configuration
//@PropertySource("classpath:dao.properties")
public class OrderDaoFactory implements FactoryBean<OrderDao> {

//    @Value("${config_dao_impl}")
    private String valueDao=DaoPropertiesHandler.getProperty("config_dao_impl").orElse(null);
    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: ";

    @Override
    public OrderDao getObject() throws Exception {
        if (valueDao.equalsIgnoreCase("json")) {
            log.info("Get data from file category.json");
            return new OrderDaoJsonImpl();
        } else if (valueDao.equalsIgnoreCase("xml")) {
            log.info("Get data from file category.xml");
            return new OrderDaoXmlImpl();
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }

    @Override
    public Class<?> getObjectType() {
        if (valueDao.equalsIgnoreCase("json")) {
            return OrderDaoJsonImpl.class;
        } else if (valueDao.equalsIgnoreCase("xml")) {
            return OrderDaoXmlImpl.class;
        }
        log.warn(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
        throw new DaoException(GET_DAO_TYPE_ERROR_MESSAGE + valueDao);
    }
}
