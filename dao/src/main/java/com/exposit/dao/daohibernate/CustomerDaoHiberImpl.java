package com.exposit.dao.daohibernate;

import com.exposit.api.dao.CustomerDao;
import com.exposit.model.db.CustomerDb;

public class CustomerDaoHiberImpl extends AbstractDaoHiberImpl<CustomerDb> implements CustomerDao {

    @Override
    public void save(CustomerDb entity) {
        if (entity.getId() == null) {
            this.entityManager.persist(entity);
        }
    }

    @Override
    protected Class<CustomerDb> getClazz() {
        return CustomerDb.class;
    }
}
