package com.exposit.dao.daojson;

import com.exposit.api.dao.StoreDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingStoreJson;
import com.exposit.model.StoreEntity;

import java.util.List;


public class StoreDaoJsonImpl extends AbstractDaoJsonImpl<StoreEntity> implements StoreDao {

    private static StoreDao instance;

    private StoreDaoJsonImpl() {

    List<StoreEntity> store = MarshallingStoreJson.deSerializeStore();
        for (StoreEntity entity : store) {
            this.save(entity);
        }
    }

    public static StoreDao getInstance() {
        if (instance == null) {
            instance = new StoreDaoJsonImpl();
        }
        return instance;
    }

    @Override
    public void save(StoreEntity entity) {
        entity.setId(IdGenerator.generateStoreId());
        repository.add(entity);
    }
}
