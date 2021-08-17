package com.exposit.dao.daorepository;

import com.exposit.api.dao.StoreDao;
import com.exposit.domain.model.db.StoreDb;

import java.util.List;

public class StoreDaoRepositoryImpl implements StoreDao {
    @Override
    public void save(StoreDb entity) {

    }

    @Override
    public void saveToFile(List<StoreDb> entity) {

    }

    @Override
    public StoreDb getById(Long id) {
        return null;
    }

    @Override
    public void delete(StoreDb entity) {

    }

    @Override
    public void update(Long id, StoreDb entity) {

    }

    @Override
    public List<StoreDb> getAll() {
        return null;
    }
}
