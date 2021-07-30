package com.exposit.dao.daojson;

import com.exposit.api.dao.CustomerDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingCustomerJson;
import com.exposit.model.CustomerEntity;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("customerjson")
public class CustomerDaoJsonImpl extends AbstractDaoJsonImpl<CustomerEntity> implements CustomerDao {

    private CustomerDao customerDao;

    private CustomerDaoJsonImpl() {
        List<CustomerEntity> customer = MarshallingCustomerJson.deSerializeCustomer();
        for (CustomerEntity entity : customer) {
            this.save(entity);
        }
        IdGenerator.setCustomerId((long) customer.size() + 1);
    }

    @Override
    public void save(CustomerEntity entity) {
        entity.setId(IdGenerator.generateCustomerId());
        repository.add(entity);
    }
}
