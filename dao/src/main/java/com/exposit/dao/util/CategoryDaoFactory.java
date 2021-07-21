package com.exposit.dao.util;

import com.exposit.api.dao.CategoryDao;
import com.exposit.dao.daoJson.CategoryDaoJsonImpl;
import com.exposit.dao.daoXml.CategoryDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;

@Log4j
public final class CategoryDaoFactory {

    private static final String GET_DAO_TYPE_ERROR_MESSAGE
            = "can not find dao by property: %p";

    private CategoryDaoFactory() {
    }

    public static CategoryDao getCategoryDaoFromProperties(String property) {
        if (property.equalsIgnoreCase("json")) {
            return CategoryDaoJsonImpl.getInstance();
        } else if (property.equalsIgnoreCase("xml")) {
            return CategoryDaoXmlImpl.getInstance();
        }
        log.warn(String.format(GET_DAO_TYPE_ERROR_MESSAGE, property));
        throw new DaoException(String
                .format(GET_DAO_TYPE_ERROR_MESSAGE, property));
    }
}
