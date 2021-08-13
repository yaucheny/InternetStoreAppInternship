package com.exposit.api.dao;

import com.exposit.model.db.StoreDb;

import java.util.List;

public interface StoreDao extends GenericDao<StoreDb> {

    void save(StoreDb entity);

    void saveToFile(List<StoreDb> entity);

}
