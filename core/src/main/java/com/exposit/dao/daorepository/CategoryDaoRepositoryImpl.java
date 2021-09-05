package com.exposit.dao.daorepository;

import com.exposit.api.dao.CategoryDao;
import com.exposit.dao.daorepository.repository.CategoryRepository;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.domain.model.entity.CategoryEntity;
import com.exposit.utils.exceptions.NotFoundException;
import com.exposit.utils.marshelling.MarshallingXml;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;


public class CategoryDaoRepositoryImpl implements CategoryDao {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryDaoRepositoryImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    private CategoryRepository categoryRepository;
    private ModelMapper mapper;


    @Override
    @Transactional
    public void save(CategoryDb categoryDb) {
        if (categoryDb.getId() == null) {
            CategoryEntity categoryEntity = mapper.map(categoryDb, CategoryEntity.class);
            if (categoryDb.getParentId() != null) {
                categoryEntity.setParent(categoryRepository.getById(categoryDb.getParentId()));
            }
            categoryRepository.save(categoryEntity);
        }
    }

    @Override
    @Transactional
    public void saveToFile(List<CategoryDb> entity) {
        MarshallingXml.serializeJsonEntity(entity);
    }


    @Override
    @Transactional(readOnly = true)
    public CategoryDb getById(Long id) {
        try {
            CategoryEntity categoryEntity = categoryRepository.getById(id);
            return mapper.map(categoryEntity, CategoryDb.class);
        } catch (Exception e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id));
        }
    }

    @Override
    @Transactional
    public void delete(CategoryDb categoryDb) {
        if (categoryDb.getId() != null) {
            CategoryEntity categoryEntity = mapper.map(categoryDb, CategoryEntity.class);
            categoryRepository.delete(categoryEntity);
        }
    }

    @Override
    @Transactional
    public void update(Long id, CategoryDb categoryDb) {
        if (categoryDb.getId() != null) {
            CategoryEntity categoryEntityToUpdate = categoryRepository.getById(id);
            CategoryEntity categoryEntity = mapper.map(categoryDb, CategoryEntity.class);
            categoryEntityToUpdate.setName(categoryEntity.getName());
            categoryEntityToUpdate.setChildList(categoryEntity.getChildList());
            categoryEntityToUpdate.setParent(categoryEntity.getParent());
            categoryRepository.save(categoryEntityToUpdate);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDb> getAll() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        Type listType = new TypeToken<List<CategoryDb>>() {
        }.getType();
        return mapper.map(categoryEntityList, listType);
    }

    @Autowired
    public void setMapper(ModelMapper mapper1) {
        this.mapper = mapper1;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository1) {
        this.categoryRepository = categoryRepository1;
    }
}
