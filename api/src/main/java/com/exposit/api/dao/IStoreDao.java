package com.exposit.api.dao;

import com.exposit.model.Store;

public interface IStoreDao extends IGenericDao<Store> {

    void save(Store entity);
}
