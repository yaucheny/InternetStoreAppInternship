package com.exposit.dao.util;

import com.exposit.api.dao.OrderDao;
import com.exposit.dao.daojson.OrderDaoJsonImpl;
import com.exposit.dao.daoxml.OrderDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@Component
@Log4j
public final class OrderDaoFactory {

    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: %p";

    private OrderDaoFactory() {
    }

    public static OrderDao getOrderDaoFromProperties(String property) {
        if (property.equalsIgnoreCase("json")) {
            return OrderDaoJsonImpl.getInstance();
        } else if (property.equalsIgnoreCase("xml")) {
            return OrderDaoXmlImpl.getInstance();
        }
        log.warn(String.format(GET_DAO_TYPE_ERROR_MESSAGE, property));
        throw new DaoException(String
                .format(GET_DAO_TYPE_ERROR_MESSAGE, property));
    }
}
