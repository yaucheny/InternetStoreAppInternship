package com.exposit.dao;

import com.exposit.api.dao.IStoreDao;
import com.exposit.idGenerators.IdGenerator;
import com.exposit.marshelling.UnMarshallingJsonHandlerOrder;
import com.exposit.marshelling.UnMarshallingJsonHandlerStore;
import com.exposit.model.Order;
import com.exposit.model.Store;

import java.util.List;

public class StoreDao extends AbstractDao<Store> implements IStoreDao {

    private static StoreDao instance;

    private StoreDao(){
        List<Store> store = UnMarshallingJsonHandlerStore.deSerializeStore();
        for (Store entity : store) {
            entity.setId(IdGenerator.generateStoreId());
            this.save(entity);
        }
    }

    public static StoreDao getInstance(){
        if (instance==null){
            instance=new StoreDao();
        }
        return instance;
    }

    @Override
    public void save(Store entity) {
        entity.setId(IdGenerator.generateStoreId());
        repository.add(entity);
    }
}
