package com.exposit.dao.util;

import com.exposit.api.dao.CustomerDao;
import com.exposit.dao.daojson.CustomerDaoJsonImpl;
import com.exposit.dao.daoxml.CustomerDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j
public final class CustomerDaoFactory {

    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: %p";
    @Autowired
    private static CustomerDaoJsonImpl customerDaoJson;
    @Autowired
    private static CustomerDaoXmlImpl customerDaoXml;

    private CustomerDaoFactory() {
    }

    public static CustomerDao getCustomerDaoFromProperties(String property) {
        if (property.equalsIgnoreCase("json")) {
            return customerDaoJson;
        } else if (property.equalsIgnoreCase("xml")) {
            return customerDaoXml;
        }
        log.warn(String.format(GET_DAO_TYPE_ERROR_MESSAGE, property));
        throw new DaoException(String
                .format(GET_DAO_TYPE_ERROR_MESSAGE, property));
    }
}
