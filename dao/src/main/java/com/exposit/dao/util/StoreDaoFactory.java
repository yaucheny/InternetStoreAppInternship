package com.exposit.dao.util;

import com.exposit.api.dao.StoreDao;
import com.exposit.dao.daoJson.StoreDaoJsonImpl;
import com.exposit.dao.daoXml.StoreDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;

@Log4j
public final class StoreDaoFactory {

    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: %p";

    private StoreDaoFactory() {
    }

    public static StoreDao getStoreDaoFromProperties(String property) {
        if (property.equalsIgnoreCase("json")) {
            return StoreDaoJsonImpl.getInstance();
        } else if (property.equalsIgnoreCase("xml")) {
            return StoreDaoXmlImpl.getInstance();
        }
        log.warn(String.format(GET_DAO_TYPE_ERROR_MESSAGE, property));
        throw new DaoException(String
                .format(GET_DAO_TYPE_ERROR_MESSAGE, property));
    }
}
