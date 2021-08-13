package com.exposit.api.dao;

import com.exposit.model.db.ProductDb;

import java.util.List;

public interface ProductDao extends GenericDao<ProductDb> {

    void save(ProductDb entity);

    void saveToFile(List<ProductDb> entity);
}
