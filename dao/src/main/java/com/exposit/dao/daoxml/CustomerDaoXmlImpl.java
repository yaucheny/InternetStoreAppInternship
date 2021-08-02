package com.exposit.dao.daoxml;

import com.exposit.api.dao.CustomerDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingCustomerXml;
import com.exposit.model.CustomerEntity;

import java.util.List;

public class CustomerDaoXmlImpl extends AbstractDaoXmlImpl<CustomerEntity> implements CustomerDao {

    public CustomerDaoXmlImpl() {
        List<CustomerEntity> customer = MarshallingCustomerXml
                .deSerializeCustomer();
        for (CustomerEntity entity : customer) {
            this.autoLoad(entity);
        }
      }

    @Override
    public void save(CustomerEntity entity) {
        entity.setId(IdGenerator.generateCustomerId());
        repository.add(entity);
    }

    private void autoLoad(CustomerEntity entity){
        repository.add(entity);
    }
}
