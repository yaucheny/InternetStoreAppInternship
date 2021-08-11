package com.exposit.dao.daoxml;

import com.exposit.api.dao.StoreDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingStoreXml;
import com.exposit.model.db.StoreDb;

import java.util.List;

public class StoreDaoXmlImpl extends AbstractDaoXmlImpl<StoreDb> implements StoreDao {

    public StoreDaoXmlImpl() {
        List<StoreDb> store = MarshallingStoreXml.deSerializeStore();
        for (StoreDb entity : store) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(StoreDb entity) {
        entity.setId(IdGenerator.generateStoreId());
        repository.add(entity);
    }

    private void autoLoad(StoreDb entity) {
        repository.add(entity);
    }
}
