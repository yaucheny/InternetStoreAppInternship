package com.exposit.dao.daojson;

import com.exposit.api.dao.CategoryDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingCategoryJson;
import com.exposit.model.db.CategoryDb;

import java.util.List;

public class CategoryDaoJsonImpl extends AbstractDaoJsonImpl<CategoryDb> implements CategoryDao {

    public CategoryDaoJsonImpl() {
        List<CategoryDb> category = MarshallingCategoryJson.deSerializeCategory();
        for (CategoryDb entity : category) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(CategoryDb entity) {
        entity.setId(IdGenerator.generateCategoryId());
        repository.add(entity);
    }

    @Override
    public void saveToFile(List<CategoryDb> entity) {
        MarshallingCategoryJson.serializeCategory(this.getAll());
    }

    private void autoLoad(CategoryDb entity) {
        repository.add(entity);
    }
}
