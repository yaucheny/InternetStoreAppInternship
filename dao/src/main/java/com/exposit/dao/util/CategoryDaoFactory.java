package com.exposit.dao.util;

import com.exposit.api.dao.CategoryDao;
import com.exposit.dao.daojson.CategoryDaoJsonImpl;
import com.exposit.dao.daoxml.CategoryDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j
public final class CategoryDaoFactory {

    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: %p";
    @Autowired
    private static CategoryDaoJsonImpl categoryDaoJson;
    @Autowired
    private static CategoryDaoXmlImpl categoryDaoXml;

    private CategoryDaoFactory() {
    }

    public static CategoryDao getCategoryDaoFromProperties(String property) {
        if (property.equalsIgnoreCase("json")) {
            return categoryDaoJson;
        } else if (property.equalsIgnoreCase("xml")) {
            return categoryDaoXml;
        }
        log.warn(String.format(GET_DAO_TYPE_ERROR_MESSAGE, property));
        throw new DaoException(String
                .format(GET_DAO_TYPE_ERROR_MESSAGE, property));

    }
}
