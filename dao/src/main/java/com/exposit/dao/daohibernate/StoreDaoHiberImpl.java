package com.exposit.dao.daohibernate;

import com.exposit.api.dao.StoreDao;
import com.exposit.model.db.StoreDb;

import java.util.List;

public class StoreDaoHiberImpl extends AbstractDaoHiberImpl<StoreDb> implements StoreDao {

    @Override
    public void save(StoreDb entity) {
        if (entity.getId() == null) {
            this.entityManager.persist(entity);
        }
    }

    @Override
    public void saveToFile(List<StoreDb> entity) {

    }

    @Override
    protected Class<StoreDb> getClazz() {
        return StoreDb.class;
    }
}
