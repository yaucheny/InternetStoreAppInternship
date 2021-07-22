package com.exposit.dao.daojson;

import com.exposit.api.dao.CategoryDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingCategoryJson;
import com.exposit.model.CategoryEntity;

import java.util.List;

public class CategoryDaoJsonImpl extends AbstractDaoJsonImpl<CategoryEntity> implements CategoryDao {

    private static CategoryDao instance;

    private CategoryDaoJsonImpl() {
        List<CategoryEntity> category = MarshallingCategoryJson
        .deSerializeCategory();
        for (CategoryEntity entity : category) {
            this.save(entity);
        }
    }

    public static CategoryDao getInstance() {
        if (instance == null) {
            instance = new CategoryDaoJsonImpl();
        }
        return instance;
    }


    @Override
    public void save(CategoryEntity entity) {
        entity.setId(IdGenerator.generateCategoryId());
        repository.add(entity);
    }
}
