package com.exposit.dao.daojson;

import com.exposit.api.dao.CustomerDao;
import com.exposit.domain.model.db.CustomerDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingJson;

import java.util.List;

public class CustomerDaoJsonImpl extends AbstractDaoJsonImpl<CustomerDb> implements CustomerDao {

    public CustomerDaoJsonImpl() {
        List<CustomerDb> customer = MarshallingJson.deserializeJsonEntity(CustomerDb.class);
        for (CustomerDb entity : customer) {
            this.autoLoad(entity);
        }
        IdGenerator.setCustomerId((long) customer.size() + 1);
    }

    @Override
    public void save(CustomerDb entity) {
        entity.setId(IdGenerator.generateCustomerId());
        repository.add(entity);
    }
}
