package com.exposit.dao.daoxml;

import com.exposit.api.dao.StoreDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingStoreXml;
import com.exposit.model.StoreEntity;

import java.util.List;

public class StoreDaoXmlImpl extends AbstractDaoXmlImpl<StoreEntity> implements StoreDao {

    public StoreDaoXmlImpl() {
        List<StoreEntity> store = MarshallingStoreXml.deSerializeStore();
        for (StoreEntity entity : store) {
            this.autoLoad(entity);
        }
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
