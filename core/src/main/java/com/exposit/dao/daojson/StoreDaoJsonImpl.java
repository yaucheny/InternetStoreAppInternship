package com.exposit.dao.daojson;

import com.exposit.api.dao.StoreDao;
import com.exposit.domain.model.db.StoreDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingJson;

import java.util.List;

public class StoreDaoJsonImpl extends AbstractDaoJsonImpl<StoreDb> implements StoreDao {

    public StoreDaoJsonImpl() {
        List<StoreDb> store = MarshallingJson.deserializeJsonEntity(StoreDb.class);
        for (StoreDb entity : store) {
            this.autoLoad(entity);
        }
        IdGenerator.setStoreId((long) store.size() + 1);
    }

    @Override
    public void save(StoreDb entity) {
        entity.setId(IdGenerator.generateStoreId());
        repository.add(entity);
    }
}
