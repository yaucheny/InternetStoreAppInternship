package com.exposit.dao.daoxml;

import com.exposit.api.dao.CustomerDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingCustomerJson;
import com.exposit.marshelling.xml.MarshallingCategoryXml;
import com.exposit.marshelling.xml.MarshallingCustomerXml;
import com.exposit.model.CategoryEntity;
import com.exposit.model.CustomerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerDaoXml")
public class CustomerDaoXmlImpl extends AbstractDaoXmlImpl<CustomerEntity> implements CustomerDao {


    private CustomerDao customerDao;

    public CustomerDaoXmlImpl() {
        List<CustomerEntity> category = MarshallingCustomerXml
                .deSerializeCustomer();
        for (CustomerEntity entity : category) {
            this.save(entity);
        }
    }

    @Override
    public void save(CustomerEntity entity) {
        entity.setId(IdGenerator.generateCustomerId());
        repository.add(entity);
    }
}
