package com.exposit.dao.daorepository;

import com.exposit.api.dao.CategoryDao;
import com.exposit.dao.daorepository.repository.CategoryRepository;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.domain.model.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
@Transactional
public class CategoryDaoRepositoryImpl implements CategoryDao {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(CategoryDb categoryDb) {
        if (categoryDb.getId() == null) {
            CategoryEntity categoryEntity = mapper.map(categoryDb, CategoryEntity.class);
            categoryRepository.save(categoryEntity);
        }
    }

    @Override
    public void saveToFile(List<CategoryDb> categoryDbList) {

    }

    @Override
    public CategoryDb getById(Long id) {
        CategoryEntity categoryEntity = categoryRepository.getById(id);
        return mapper.map(categoryEntity, CategoryDb.class);
    }

    @Override
    public void delete(CategoryDb categoryDb) {
        if (categoryDb.getId() != null) {
            CategoryEntity categoryEntity = mapper.map(categoryDb, CategoryEntity.class);
            categoryRepository.delete(categoryEntity);
        }
    }

    @Override
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
    public List<CategoryDb> getAll() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        Type listType = new TypeToken<List<CategoryDb>>() {
        }.getType();
        return mapper.map(categoryEntityList, listType);
    }
}
