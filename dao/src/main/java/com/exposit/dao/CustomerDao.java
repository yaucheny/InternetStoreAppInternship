package com.exposit.dao;

import com.exposit.api.dao.ICustomerDao;
import com.exposit.idGenerators.IdGenerator;
import com.exposit.marshelling.UnMarshallingJsonHandlerCustomer;
import com.exposit.model.Customer;

import java.util.List;

public class CustomerDao extends AbstractDao<Customer> implements ICustomerDao {

    private static CustomerDao instance;

    private CustomerDao() {
        List<Customer> customer = UnMarshallingJsonHandlerCustomer.deSerializeCustomer();
        for (Customer entity : customer) {
            entity.setId(IdGenerator.generateCustomerId());
            this.save(entity);
        }
    }

    public static CustomerDao getInstance() {
        if (instance == null) {
            instance = new CustomerDao();
        }
        return instance;
    }

    @Override
    public void save(Customer entity) {
        entity.setId(IdGenerator.generateCustomerId());
        repository.add(entity);
    }
}
