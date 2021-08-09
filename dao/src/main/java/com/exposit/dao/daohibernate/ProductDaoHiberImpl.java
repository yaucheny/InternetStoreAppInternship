package com.exposit.dao.daohibernate;

import com.exposit.api.dao.ProductDao;
import com.exposit.model.db.ProductDb;

public class ProductDaoHiberImpl extends AbstractDaoHiberImpl<ProductDb> implements ProductDao {

    @Override
    public void save(ProductDb entity) {
        if (entity.getId() == null) {
            this.entityManager.persist(entity);
        }
    }

    @Override
    protected Class<ProductDb> getClazz() {
        return ProductDb.class;
    }
}
