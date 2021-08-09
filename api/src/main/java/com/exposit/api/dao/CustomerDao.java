package com.exposit.api.dao;

import com.exposit.model.db.CustomerDb;

public interface CustomerDao extends GenericDao<CustomerDb> {

    void save(CustomerDb entity);
}
