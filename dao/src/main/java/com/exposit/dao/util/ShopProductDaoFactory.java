package com.exposit.dao.util;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.dao.daojson.ShopProductDaoJsonImpl;
import com.exposit.dao.daoxml.ShopProductDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;

@Log4j
public final class ShopProductDaoFactory {

    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: %p";

    private ShopProductDaoFactory() {
    }

    public static ShopProductDao getShopProductDaoFromProperties(String property) {
        if (property.equalsIgnoreCase("json")) {
            return ShopProductDaoJsonImpl.getInstance();
        } else if (property.equalsIgnoreCase("xml")) {
            return ShopProductDaoXmlImpl.getInstance();
        }
        log.warn(String.format(GET_DAO_TYPE_ERROR_MESSAGE, property));
        throw new DaoException(String
                .format(GET_DAO_TYPE_ERROR_MESSAGE, property));
    }
}
