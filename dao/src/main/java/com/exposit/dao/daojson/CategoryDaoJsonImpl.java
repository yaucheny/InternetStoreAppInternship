package com.exposit.dao.daojson;

import com.exposit.api.dao.CategoryDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingCategoryJson;
import com.exposit.model.CategoryEntity;

import java.util.List;

public class CategoryDaoJsonImpl extends AbstractDaoJsonImpl<CategoryEntity> implements CategoryDao {

    public CategoryDaoJsonImpl() {
        List<CategoryEntity> category = MarshallingCategoryJson.deSerializeCategory();
        for (CategoryEntity entity : category) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(CategoryEntity entity) {
        entity.setId(IdGenerator.generateCategoryId());
        repository.add(entity);
    }

    @Override
    public void saveToFile(List<CategoryEntity> entity) {
        MarshallingCategoryJson.serializeCategory(this.getAll());
    }

    private void autoLoad(CategoryEntity entity) {
        repository.add(entity);
    }
}
