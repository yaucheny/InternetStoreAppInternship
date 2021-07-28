package com.exposit.dao.util;

import com.exposit.api.dao.OrderDao;
import com.exposit.dao.daojson.OrderDaoJsonImpl;
import com.exposit.dao.daoxml.OrderDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j
public final class OrderDaoFactory {

    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: %p";
    @Autowired
    private static OrderDaoJsonImpl orderDaoJson;
    @Autowired
    private static OrderDaoXmlImpl orderDaoXml;

    public static OrderDao getOrderDaoFromProperties(String property) {
        if (property.equalsIgnoreCase("json")) {
            return orderDaoJson;
        } else if (property.equalsIgnoreCase("xml")) {
            return orderDaoXml;
        }
        log.warn(String.format(GET_DAO_TYPE_ERROR_MESSAGE, property));
        throw new DaoException(String
                .format(GET_DAO_TYPE_ERROR_MESSAGE, property));
    }
}
