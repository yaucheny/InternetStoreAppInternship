package com.exposit.api.dao;

import com.exposit.model.db.CategoryDb;

import java.util.List;

public interface CategoryDao extends GenericDao<CategoryDb> {

    void save(CategoryDb entity);

    void saveToFile(List<CategoryDb> entity);
}
