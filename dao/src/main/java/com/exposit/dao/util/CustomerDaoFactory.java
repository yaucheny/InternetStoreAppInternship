package com.exposit.dao.util;

import com.exposit.api.dao.CustomerDao;
import com.exposit.dao.daoJson.CustomerDaoJsonImpl;
import com.exposit.dao.daoXml.CustomerDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;

@Log4j
public final class CustomerDaoFactory {

    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: %p";

    private CustomerDaoFactory() {
    }

    public static CustomerDao getCustomerDaoFromProperties(String property) {
        if (property.equalsIgnoreCase("json")) {
            return CustomerDaoJsonImpl.getInstance();
        } else if (property.equalsIgnoreCase("xml")) {
            return CustomerDaoXmlImpl.getInstance();
        }
        log.warn(String.format(GET_DAO_TYPE_ERROR_MESSAGE, property));
        throw new DaoException(String
                .format(GET_DAO_TYPE_ERROR_MESSAGE, property));
    }
}
