package com.exposit.api.dao;

import com.exposit.model.CustomerEntity;

public interface CustomerDao extends GenericDao<CustomerEntity> {

    void save(CustomerEntity entity);
}
