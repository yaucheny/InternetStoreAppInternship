package com.exposit.dao.daohibernate;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.model.db.ShopProductDb;

import java.util.List;

public class ShopProductDaoHiberImpl extends AbstractDaoHiberImpl<ShopProductDb> implements ShopProductDao {

    @Override
    public void save(ShopProductDb entity) {
        if (entity.getId() == null) {
            this.entityManager.persist(entity);
        }
    }

    @Override
    public List<ShopProductDb> sortByPrice() {
        return null;
    }

    @Override
    protected Class<ShopProductDb> getClazz() {
        return ShopProductDb.class;
    }
}
