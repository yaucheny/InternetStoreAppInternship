package com.exposit.dao.daojson;

import com.exposit.api.dao.CustomerDao;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.json.MarshallingCustomerJson;
import com.exposit.domain.model.db.CustomerDb;

import java.util.List;

public class CustomerDaoJsonImpl extends AbstractDaoJsonImpl<CustomerDb> implements CustomerDao {

    public CustomerDaoJsonImpl() {
        List<CustomerDb> customer = MarshallingCustomerJson.deSerializeCustomer();
        for (CustomerDb entity : customer) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(CustomerDb entity) {
        entity.setId(IdGenerator.generateCustomerId());
        repository.add(entity);
    }

    @Override
    public void saveToFile(List<CustomerDb> entity) {

    }

    private void autoLoad(CustomerDb entity) {
        repository.add(entity);
    }
}
