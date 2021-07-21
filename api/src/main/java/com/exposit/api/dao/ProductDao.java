package com.exposit.api.dao;

import com.exposit.model.ProductEntity;

public interface ProductDao extends GenericDao<ProductEntity> {

    void save(ProductEntity entity);
}
