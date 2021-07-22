package com.exposit.dao.util;

import com.exposit.api.dao.OrderItemDao;
import com.exposit.dao.daojson.OrderItemDaoJsonImpl;
import com.exposit.dao.daoxml.OrderItemDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;

@Log4j
public final class OrderItemDaoFactory {

    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: %p";

    private OrderItemDaoFactory() {
    }

    public static OrderItemDao getOrderItemDaoFromProperties(String property) {
        if (property.equalsIgnoreCase("json")) {
            return OrderItemDaoJsonImpl.getInstance();
        } else if (property.equalsIgnoreCase("xml")) {
            return OrderItemDaoXmlImpl.getInstance();
        }
        log.warn(String.format(GET_DAO_TYPE_ERROR_MESSAGE, property));
        throw new DaoException(String
                .format(GET_DAO_TYPE_ERROR_MESSAGE, property));
    }
}
