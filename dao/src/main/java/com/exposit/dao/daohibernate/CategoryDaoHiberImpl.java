package com.exposit.dao.daohibernate;

import com.exposit.api.dao.CategoryDao;
import com.exposit.model.db.CategoryDb;

import java.util.List;

public class CategoryDaoHiberImpl extends AbstractDaoHiberImpl<CategoryDb> implements CategoryDao {

    @Override
    protected Class<CategoryDb> getClazz() {
        return CategoryDb.class;
    }

    @Override
    public void save(CategoryDb entity) {
        if (entity.getId() == null) {
            this.entityManager.persist(entity);
        }
    }

    @Override
    public void saveToFile(List<CategoryDb> entity) {

    }

}
