package com.exposit.dao.daojson;

import com.exposit.api.dao.CustomerDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingCustomerJson;
import com.exposit.model.CustomerEntity;

import java.util.List;


public class CustomerDaoJsonImpl extends AbstractDaoJsonImpl<CustomerEntity> implements CustomerDao {

    private static CustomerDao instance;

    private CustomerDaoJsonImpl() {
        List<CustomerEntity> customer = MarshallingCustomerJson
        .deSerializeCustomer();
        for (CustomerEntity entity : customer) {
            this.save(entity);
        }
    }

    public static CustomerDao getInstance() {
        if (instance == null) {
            instance = new CustomerDaoJsonImpl();
        }
        return instance;
    }

    @Override
    public void save(CustomerEntity entity) {
        entity.setId(IdGenerator.generateCustomerId());
        repository.add(entity);
    }
}
