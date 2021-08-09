package com.exposit.api.dao;

import com.exposit.model.db.ProductDb;
import com.exposit.model.parentmodel.ProductModel;

public interface ProductDao extends GenericDao<ProductDb> {

    void save(ProductDb entity);
}
