package com.exposit.api.dao;

import com.exposit.model.db.StoreDb;

public interface StoreDao extends GenericDao<StoreDb> {

    void save(StoreDb entity);

}
