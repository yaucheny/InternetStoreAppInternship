package com.exposit.dao.daoXml;

import com.exposit.api.dao.CustomerDao;
import com.exposit.idGenerators.IdGenerator;
import com.exposit.marshelling.Xml.MarshallingCustomerXml;
import com.exposit.marshelling.json.MarshallingCustomerJson;
import com.exposit.model.CustomerEntity;

import java.util.List;


public class CustomerDaoXmlImpl extends AbstractDaoXmlImpl<CustomerEntity> implements CustomerDao {

    private static CustomerDao instance;

    private CustomerDaoXmlImpl() {
        List<CustomerEntity> customer = MarshallingCustomerXml
        .deSerializeCustomer();
        for (CustomerEntity entity : customer) {
  //          entity.setId(IdGenerator.generateCustomerId());
            this.save(entity);
        }
    }

    public static CustomerDao getInstance() {
        if (instance == null) {
            instance = new CustomerDaoXmlImpl();
        }
        return instance;
    }

    @Override
    public void save(CustomerEntity entity) {
        entity.setId(IdGenerator.generateCustomerId());
        repository.add(entity);
    }
}
