package com.exposit.api.dao;

import com.exposit.model.db.CustomerDb;

import java.util.List;

public interface CustomerDao extends GenericDao<CustomerDb> {

    void save(CustomerDb entity);

    void saveToFile(List<CustomerDb> entity);
}
