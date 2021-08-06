package com.exposit.dao.daojson;

import com.exposit.api.dao.StoreDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.model.StoreEntity;

public class StoreDaoJsonImpl extends AbstractDaoJsonImpl<StoreEntity> implements StoreDao {

    public StoreDaoJsonImpl() {
//        List<StoreEntity> store = MarshallingStoreJson.deSerializeStore();
//        for (StoreEntity entity : store) {
//            this.autoLoad(entity);
//        }
    }

    @Override
    public void save(StoreEntity entity) {
        entity.setId(IdGenerator.generateStoreId());
        repository.add(entity);
    }

    private void autoLoad(StoreEntity entity){
        repository.add(entity);
    }
}
