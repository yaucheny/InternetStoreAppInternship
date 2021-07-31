package com.exposit.dao.daoxml;

import com.exposit.api.dao.CustomerDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingCustomerXml;
import com.exposit.model.CustomerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerxml")
public class CustomerDaoXmlImpl extends AbstractDaoXmlImpl<CustomerEntity> implements CustomerDao {

    public CustomerDaoXmlImpl() {
        List<CustomerEntity> customer = MarshallingCustomerXml
                .deSerializeCustomer();
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
