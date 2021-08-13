package com.exposit.dao.daohibernate;

import com.exposit.api.dao.CustomerDao;
import com.exposit.model.db.CustomerDb;

import java.util.List;

public class CustomerDaoHiberImpl extends AbstractDaoHiberImpl<CustomerDb> implements CustomerDao {

    @Override
    protected Class<CustomerDb> getClazz() {
        return CustomerDb.class;
    }

    @Override
    public void save(CustomerDb entity) {
        if (entity.getId() == null) {
            this.entityManager.persist(entity);
        }
    }

    @Override
    public void saveToFile(List<CustomerDb> entity) {

    }
}
