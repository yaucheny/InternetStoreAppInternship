package com.exposit.dao.daoxml;

import com.exposit.api.dao.StoreDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingStoreXml;
import com.exposit.model.StoreEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("storexml")
public class StoreDaoXmlImpl extends AbstractDaoXmlImpl<StoreEntity> implements StoreDao {

    public StoreDaoXmlImpl() {
        List<StoreEntity> store = MarshallingStoreXml.deSerializeStore();
        for (StoreEntity entity : store) {
            this.save(entity);
        }
        IdGenerator.setStoreId((long) store.size() + 1);
    }

    @Override
    public void save(StoreEntity entity) {
        entity.setId(IdGenerator.generateStoreId());
        repository.add(entity);
    }

}
