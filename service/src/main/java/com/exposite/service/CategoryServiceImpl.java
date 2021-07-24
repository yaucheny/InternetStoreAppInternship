package com.exposite.service;

import com.exposit.api.dao.CategoryDao;
import com.exposit.api.service.CategoryService;
import com.exposit.dao.util.CategoryDaoFactory;
import com.exposit.dao.util.DaoPropertiesHandler;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingCategoryJson;
import com.exposit.model.CategoryEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Log4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String PROPERTY;

    static {
        PROPERTY = DaoPropertiesHandler
                .getProperty("dao.serialization.config_dao_impl")
                .orElseThrow(() -> new ServiceException("Serialization path not found"));
    }

    private final CategoryDao categoryDao;
    private static CategoryServiceImpl instance;
    private static final String CAN_NOT_DELETE_CATEGORY
            = "can not delete category";
    private static final String CAN_NOT_UPDATE_CATEGORY
            = "can not update category";

    public CategoryServiceImpl() {
        categoryDao = CategoryDaoFactory.getCategoryDaoFromProperties(PROPERTY);
    }

    public static CategoryServiceImpl getInstance() {
        if (instance == null) {
            instance = new CategoryServiceImpl();
        }
        return instance;
    }

    @Override
    public CategoryEntity addCategory(String name, Long parentId) {
        CategoryEntity category = new CategoryEntity(name, parentId);
        categoryDao.save(category);
        if (parentId != null) {
            CategoryEntity parent = categoryDao.getById(parentId);
            if (parent.getChildList() == null) {
                List<CategoryEntity> categoryList = new ArrayList<>();
                parent.setChildList(categoryList);
            }
            parent.getChildList().add(category);
        }
        return category;
    }

    @Override
    public void deleteCategory(Long id) {
        try {
            categoryDao.delete(categoryDao.getById(id));
        } catch (DaoException e) {
            log.warn(CAN_NOT_DELETE_CATEGORY, e);
            throw new ServiceException(CAN_NOT_DELETE_CATEGORY, e);
        }
    }

    @Override
    public void updateCategory(Long id, String name,
                               Long parentId) {
        if (categoryDao.getById(id) != null) {
            CategoryEntity category = new CategoryEntity(id,
                    name, parentId);
            category.setId(id);
            categoryDao.update(id, category);
        } else {
            log.warn(CAN_NOT_UPDATE_CATEGORY);
            throw new ServiceException(CAN_NOT_UPDATE_CATEGORY);
        }
    }

    @Override
    public CategoryEntity getCategoryById(Long id) {
        return categoryDao.getById(id);
    }

    @Override
    public List<CategoryEntity> getAllCategory() {
        return categoryDao.getAll();
    }

    @Override
    public void saveCategoryToFile() {
        MarshallingCategoryJson.serializeCategory(categoryDao.getAll());
    }
}