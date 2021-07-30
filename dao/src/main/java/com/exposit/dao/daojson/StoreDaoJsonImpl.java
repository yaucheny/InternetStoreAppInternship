package com.exposit.dao.daojson;

import com.exposit.api.dao.StoreDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingStoreJson;
import com.exposit.model.StoreEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("storejson")
public class StoreDaoJsonImpl extends AbstractDaoJsonImpl<StoreEntity> implements StoreDao {

    private StoreDao storeDao;

    private StoreDaoJsonImpl() {
        List<StoreEntity> store = MarshallingStoreJson.deSerializeStore();
        for (StoreEntity entity : store) {
            this.save(entity);
        }
        IdGenerator.setStoreId((long) store.size()+1);
    }


    @Override
    public void save(StoreEntity entity) {
        entity.setId(IdGenerator.generateStoreId());
        repository.add(entity);
    }

    public void loadDataFromFile(){
        List<StoreEntity> store = MarshallingStoreJson.deSerializeStore();
        for (StoreEntity entity : store) {
            this.save(entity);
        }
    }
}
