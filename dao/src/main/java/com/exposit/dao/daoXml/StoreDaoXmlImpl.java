package com.exposit.dao.daoXml;

import com.exposit.api.dao.StoreDao;
import com.exposit.idGenerators.IdGenerator;
import com.exposit.marshelling.Xml.MarshallingStoreXml;
import com.exposit.marshelling.json.MarshallingStoreJson;
import com.exposit.model.StoreEntity;

import java.util.List;


public class StoreDaoXmlImpl extends AbstractDaoXmlImpl<StoreEntity> implements StoreDao {

    private static StoreDao instance;

    private StoreDaoXmlImpl() {

        List<StoreEntity> store = MarshallingStoreXml.deSerializeStore();
        for (StoreEntity entity : store) {
 //           entity.setId(IdGenerator.generateStoreId());
            this.save(entity);
        }
    }

    public static StoreDao getInstance() {
        if (instance == null) {
            instance = new StoreDaoXmlImpl();
        }
        return instance;
    }

    @Override
    public void save(StoreEntity entity) {
        entity.setId(IdGenerator.generateStoreId());
        repository.add(entity);
    }
}
