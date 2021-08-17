package com.exposit.dao.daorepository;

import com.exposit.api.dao.CustomerDao;
import com.exposit.domain.model.db.CustomerDb;

import java.util.List;

public class CustomerDaoRepositoryImpl implements CustomerDao {
    @Override
    public void save(CustomerDb entity) {

    }

    @Override
    public void saveToFile(List<CustomerDb> entity) {

    }

    @Override
    public CustomerDb getById(Long id) {
        return null;
    }

    @Override
    public void delete(CustomerDb entity) {

    }

    @Override
    public void update(Long id, CustomerDb entity) {

    }

    @Override
    public List<CustomerDb> getAll() {
        return null;
    }
}
