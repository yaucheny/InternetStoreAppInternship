package com.exposit.dao.daojson;

import com.exposit.api.dao.StoreDao;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.json.MarshallingStoreJson;
import com.exposit.domain.model.db.StoreDb;

import java.util.List;

public class StoreDaoJsonImpl extends AbstractDaoJsonImpl<StoreDb> implements StoreDao {

    public StoreDaoJsonImpl() {
        List<StoreDb> store = MarshallingStoreJson.deSerializeStore();
        for (StoreDb entity : store) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(StoreDb entity) {
        entity.setId(IdGenerator.generateStoreId());
        repository.add(entity);
    }

    @Override
    public void saveToFile(List<StoreDb> entity) {

    }

    private void autoLoad(StoreDb entity){
        repository.add(entity);
    }
}
