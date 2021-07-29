package com.exposit.api.dao;

import com.exposit.model.StoreEntity;

public interface StoreDao extends GenericDao<StoreEntity> {

    void save(StoreEntity entity);

}
