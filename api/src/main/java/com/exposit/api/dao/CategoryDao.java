package com.exposit.api.dao;

import com.exposit.model.CategoryEntity;

public interface CategoryDao extends GenericDao<CategoryEntity> {
    void save(CategoryEntity entity);
}
