package com.exposit.api.dao;

import com.exposit.model.CategoryEntity;

import java.util.List;

public interface CategoryDao extends GenericDao<CategoryEntity> {

    void save(CategoryEntity entity);

    void saveToFile(List<CategoryEntity> entity);
}
