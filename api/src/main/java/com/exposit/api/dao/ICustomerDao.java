package com.exposit.api.dao;

import com.exposit.model.Customer;

public interface ICustomerDao extends IGenericDao<Customer> {

    void save(Customer entity);
}
