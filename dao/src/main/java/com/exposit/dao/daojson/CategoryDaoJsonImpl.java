package com.exposit.dao.daojson;

import com.exposit.api.dao.CategoryDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingCategoryJson;
import com.exposit.model.CategoryEntity;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("categoryDaoJson")
public class CategoryDaoJsonImpl extends AbstractDaoJsonImpl<CategoryEntity> implements CategoryDao {

    private CategoryDao categoryDao;

    private CategoryDaoJsonImpl() {
        List<CategoryEntity> category = MarshallingCategoryJson
                .deSerializeCategory();
        for (CategoryEntity entity : category) {
            this.save(entity);
        }
    }

    @Override
    public void save(CategoryEntity entity) {
        entity.setId(IdGenerator.generateCategoryId());
        repository.add(entity);
    }
}
