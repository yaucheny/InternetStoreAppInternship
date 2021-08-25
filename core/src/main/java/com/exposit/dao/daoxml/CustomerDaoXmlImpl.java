package com.exposit.dao.daoxml;

import com.exposit.api.dao.CustomerDao;
import com.exposit.domain.model.db.CustomerDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingXml;

import java.util.List;

public class CustomerDaoXmlImpl extends AbstractDaoXmlImpl<CustomerDb> implements CustomerDao {

    public CustomerDaoXmlImpl() {
        List<CustomerDb> customer = MarshallingXml.deserializeXmlEntity(CustomerDb.class);
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
