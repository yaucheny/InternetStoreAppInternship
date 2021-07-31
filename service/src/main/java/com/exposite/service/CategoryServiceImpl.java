package com.exposite.service;

import com.exposit.api.dao.CategoryDao;
import com.exposit.api.service.CategoryService;
import com.exposit.dto.CategoryDto;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingCategoryJson;
import com.exposit.model.CategoryEntity;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.reflect.Type;
import java.util.List;

@Log4j
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CategoryDao categoryDao;

    private static final String CAN_NOT_DELETE_CATEGORY
            = "can not delete category";
    private static final String CAN_NOT_ADD_CATEGORY
            = "can not add category";
    private static final String CAN_NOT_UPDATE_CATEGORY
            = "can not update category";


    @Override
    public void addCategory(CategoryDto categoryDto) {
        if (categoryDto.getId() == null) {
            CategoryEntity category = mapper
                    .map(categoryDto, CategoryEntity.class);
            categoryDao.save(category);
        } else {
            log.warn(CAN_NOT_ADD_CATEGORY);
            throw new DaoException(CAN_NOT_ADD_CATEGORY);
        }
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
    public void updateCategory(Long id, CategoryDto categoryDto) {
        if (categoryDao.getById(id) != null) {
            CategoryEntity category = mapper
                    .map(categoryDto, CategoryEntity.class);
            category.setId(id);
            categoryDao.update(id, category);
        } else {
            log.warn(CAN_NOT_UPDATE_CATEGORY);
            throw new ServiceException(CAN_NOT_UPDATE_CATEGORY);
        }
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        CategoryEntity categoryEntity = categoryDao.getById(id);
        return mapper.map(categoryEntity, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<CategoryEntity> categoryEntityList = categoryDao.getAll();
        Type listType = new TypeToken<List<CategoryDto>>() {
        }.getType();
        return mapper.map(categoryEntityList, listType);
    }

    @Override
    public void saveCategoryToFile() {
        MarshallingCategoryJson.serializeCategory(categoryDao.getAll());
    }
}