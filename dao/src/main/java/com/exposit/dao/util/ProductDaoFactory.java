package com.exposit.dao.util;

import com.exposit.api.dao.ProductDao;
import com.exposit.dao.daojson.ProductDaoJsonImpl;
import com.exposit.dao.daoxml.ProductDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Log4j
public final class ProductDaoFactory {
//
//    private static final String GET_DAO_TYPE_ERROR_MESSAGE
//            = "can not find dao by property: %p";
//    @Autowired
//    private static ProductDaoJsonImpl productDaoJson;
//    @Autowired
//    private static ProductDaoXmlImpl productDaoXml;
//
//    public static ProductDao getProductDaoFromProperties(String property) {
//        if (property.equalsIgnoreCase("json")) {
//            return productDaoJson;
//        } else if (property.equalsIgnoreCase("xml")) {
//            return productDaoXml;
//        }
//        log.warn(String.format(GET_DAO_TYPE_ERROR_MESSAGE, property));
//        throw new DaoException(String
//                .format(GET_DAO_TYPE_ERROR_MESSAGE, property));
//    }
}
