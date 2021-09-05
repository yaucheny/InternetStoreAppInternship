package com.exposit.dao.daoxml;

import com.exposit.api.dao.StoreDao;
import com.exposit.domain.model.db.StoreDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingXml;

import java.util.List;
/**
 * Implementation of {@link StoreDao} interface.
 * Implementation works with Jackson API and xml format files
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class StoreDaoXmlImpl extends AbstractDaoXmlImpl<StoreDb> implements StoreDao {

    public StoreDaoXmlImpl() {
        List<StoreDb> store = MarshallingXml.deserializeXmlEntity(StoreDb.class);
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
