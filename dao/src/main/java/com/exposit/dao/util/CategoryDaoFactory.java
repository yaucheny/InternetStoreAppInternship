package com.exposit.dao.util;

import com.exposit.api.dao.CategoryDao;
import com.exposit.dao.daojson.CategoryDaoJsonImpl;
import com.exposit.dao.daoxml.CategoryDaoXmlImpl;
import com.exposit.exceptions.DaoException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Log4j
public final class CategoryDaoFactory {
//    @Autowired
//    private List<CategoryDao> categoryDaoList;
//
//    private static final Map<String, CategoryDao> myCategoryCache = new HashMap<>();
//
//    public void initMyCategoryCache() {
//        for (CategoryDao categoryDao : categoryDaoList) {
//            myCategoryCache.put(categoryDao.getType(), categoryDao)
//        }
//    }
//
//    public static CategoryDao getCategoryDao(String type) {
//        CategoryDao categoryDao = myCategoryCache.get(type);
//        if
//    }



//    private static final String GET_DAO_TYPE_ERROR_MESSAGE
//            = "can not find dao by property: %p";
//    @Autowired
//    private static CategoryDaoJsonImpl categoryDaoJson;
//    @Autowired
//    private static CategoryDaoXmlImpl categoryDaoXml;
//
//
//    public static CategoryDao getCategoryDaoFromProperties(String property) {
//        if (property.equalsIgnoreCase("json")) {
//            return categoryDaoJson;
//        } else if (property.equalsIgnoreCase("xml")) {
//            return categoryDaoXml;
//        }
//        log.warn(String.format(GET_DAO_TYPE_ERROR_MESSAGE, property));
//        throw new DaoException(String
//                .format(GET_DAO_TYPE_ERROR_MESSAGE, property));
//
//    }
}
