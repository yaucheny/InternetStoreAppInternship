package com.exposit.service;

import com.exposit.api.dao.CategoryDao;
import com.exposit.api.service.CategoryService;
import com.exposit.domain.dto.CategoryDto;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.utils.exceptions.NotFoundException;
import com.exposit.utils.exceptions.ServiceException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private final ModelMapper mapper;
    private final CategoryDao categoryDao;
    private static final String CAN_NOT_DELETE_CATEGORY = "can not delete category";
    private static final String CAN_NOT_ADD_CATEGORY = "can not add category";
    private static final String CAN_NOT_UPDATE_CATEGORY = "can not update category";

    @Override
    public void addCategory(CategoryDto categoryDto) {
        if (categoryDto.getId() == null) {
            try {
                CategoryDb categoryDb = mapper.map(categoryDto, CategoryDb.class);
                categoryDao.save(categoryDb);
            } catch (Exception e) {
                LOG.error(CAN_NOT_ADD_CATEGORY);
                throw new ServiceException(CAN_NOT_ADD_CATEGORY, e);
            }
        }
    }

    @Override
    public void deleteCategory(Long id) {
        try {
            categoryDao.delete(categoryDao.getById(id));
        } catch (NotFoundException e) {
            LOG.error(CAN_NOT_DELETE_CATEGORY);
            throw new ServiceException(CAN_NOT_DELETE_CATEGORY, e);
        }
    }

    @Override
    public void updateCategory(Long id, CategoryDto categoryDto) {
        if (categoryDao.getById(id) != null) {
            try {
                CategoryDb category = mapper.map(categoryDto, CategoryDb.class);
                category.setId(id);
                categoryDao.update(id, category);
            } catch (NotFoundException e) {
                LOG.error(CAN_NOT_UPDATE_CATEGORY);
                throw new ServiceException(CAN_NOT_UPDATE_CATEGORY);
            }
        }
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        CategoryDb categoryDb = categoryDao.getById(id);
        return mapper.map(categoryDb, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<CategoryDb> categoryDbList = categoryDao.getAll();
        Type listType = new TypeToken<List<CategoryDto>>() {
        }.getType();
        return mapper.map(categoryDbList, listType);
    }

    @Override
    public void saveCategoryToFile() {
        categoryDao.saveToFile(categoryDao.getAll());
    }


}