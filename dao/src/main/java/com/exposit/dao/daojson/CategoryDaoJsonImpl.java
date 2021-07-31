package com.exposit.dao.daojson;

import com.exposit.api.dao.CategoryDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingCategoryJson;
import com.exposit.model.CategoryEntity;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("categoryjson")
public class CategoryDaoJsonImpl
        extends AbstractDaoJsonImpl<CategoryEntity> implements CategoryDao {

    private CategoryDaoJsonImpl() {
        List<CategoryEntity> category = MarshallingCategoryJson
                .deSerializeCategory();
        for (CategoryEntity entity : category) {
            this.save(entity);
        }
        IdGenerator.setCategoryId((long) category.size() + 1);
    }

    @Override
    public void save(CategoryEntity entity) {
        entity.setId(IdGenerator.generateCategoryId());
        repository.add(entity);
    }
}
