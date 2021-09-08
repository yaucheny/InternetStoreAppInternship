package com.exposit.dao.daojson;

import com.exposit.api.dao.CategoryDao;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingJson;

import java.util.List;

/**
 * Implementation of {@link CategoryDao} interface.
 * Implementation works with Jackson API and json format files
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
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
