package com.exposit.dao.util;

import com.exposit.api.dao.StoreDao;
import com.exposit.dao.daojson.StoreDaoJsonImpl;
import com.exposit.dao.daoxml.StoreDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Log4j
public final class StoreDaoFactory {
//
//    private static final String GET_DAO_TYPE_ERROR_MESSAGE
//            = "can not find dao by property: %p";
//    @Autowired
//    private static StoreDaoJsonImpl storeDaoJson;
//    @Autowired
//    private static StoreDaoXmlImpl storeDaoXml;
//
//    public static StoreDao getStoreDaoFromProperties(String property) {
//        if (property.equalsIgnoreCase("json")) {
//            return storeDaoJson;
//        } else if (property.equalsIgnoreCase("xml")) {
//            return storeDaoXml;
//        }
//        log.warn(String.format(GET_DAO_TYPE_ERROR_MESSAGE, property));
//        throw new DaoException(String
//                .format(GET_DAO_TYPE_ERROR_MESSAGE, property));
//    }
}
