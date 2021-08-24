package com.exposit.dao.daoxml;

import com.exposit.api.dao.CategoryDao;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingXml;

import java.util.List;

public class CategoryDaoXmlImpl extends AbstractDaoXmlImpl<CategoryDb> implements CategoryDao {

    public CategoryDaoXmlImpl() {
        List<CategoryDb> category = MarshallingXml.deserializeXmlEntity(CategoryDb.class);
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
