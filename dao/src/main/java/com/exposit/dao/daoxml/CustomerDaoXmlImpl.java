package com.exposit.dao.daoxml;

import com.exposit.api.dao.CustomerDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingCustomerXml;
import com.exposit.model.db.CustomerDb;

import java.util.List;

public class CustomerDaoXmlImpl extends AbstractDaoXmlImpl<CustomerDb> implements CustomerDao {

    public CustomerDaoXmlImpl() {
        List<CustomerDb> customer = MarshallingCustomerXml.deSerializeCustomer();
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
