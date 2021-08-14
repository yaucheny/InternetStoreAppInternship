package com.exposite.service;

import com.exposit.api.dao.CategoryDao;
import com.exposit.api.service.CategoryService;
import com.exposit.dto.CategoryDto;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.model.db.CategoryDb;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Log4j
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final ModelMapper mapper;

    private final CategoryDao categoryDao;
    private static final String CAN_NOT_DELETE_CATEGORY = "can not delete category";
    private static final String CAN_NOT_ADD_CATEGORY = "can not add category";
    private static final String CAN_NOT_UPDATE_CATEGORY = "can not update category";

    @Override
    public void addCategory(CategoryDto categoryDto) {
        if (categoryDto.getId() == null) {
            CategoryDb categoryDb = mapper.map(categoryDto, CategoryDb.class);
            categoryDao.save(categoryDb);
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
            CategoryDb category = mapper.map(categoryDto, CategoryDb.class);
            category.setId(id);
            categoryDao.update(id, category);
        } else {
            log.warn(CAN_NOT_UPDATE_CATEGORY);
            throw new ServiceException(CAN_NOT_UPDATE_CATEGORY);
        }
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        CategoryDb categoryDbEntity = categoryDao.getById(id);
        return mapper.map(categoryDbEntity, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<CategoryDb> categoryDbEntityList = categoryDao.getAll();
        Type listType = new TypeToken<List<CategoryDto>>() {
        }.getType();
        return mapper.map(categoryDbEntityList, listType);
    }

    @Override
    public void saveCategoryToFile() {
        categoryDao.saveToFile(categoryDao.getAll());
    }
}