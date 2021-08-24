package com.exposit.dao.daojson;

import com.exposit.api.dao.CategoryDao;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingJson;

import java.util.List;

public class CategoryDaoJsonImpl extends AbstractDaoJsonImpl<CategoryDb> implements CategoryDao {

    public CategoryDaoJsonImpl() {
        List<CategoryDb> category = MarshallingJson.deserializeJsonEntity(CategoryDb.class);
        for (CategoryDb entity : category) {
            this.autoLoad(entity);
        }
        IdGenerator.setCategoryId((long) category.size() + 1);
    }

    @Override
    public void save(CategoryDb entity) {
        entity.setId(IdGenerator.generateCategoryId());
        repository.add(entity);
    }
}
