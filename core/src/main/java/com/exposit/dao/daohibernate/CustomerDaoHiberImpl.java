package com.exposit.dao.daohibernate;

import com.exposit.api.dao.CustomerDao;
import com.exposit.domain.model.db.CustomerDb;
import com.exposit.domain.model.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoHiberImpl implements CustomerDao {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Autowired
    private ModelMapper mapper;

    private List<CustomerEntity> repository = new ArrayList<>();

    @Override
    public void save(CustomerDb customerDb) {
        if (customerDb.getId() == null) {
            CustomerEntity customerEntity = mapper.map(customerDb, CustomerEntity.class);
            this.entityManager.persist(customerEntity);
        }
    }

    @Override
    public void saveToFile(List<CustomerDb> entity) {

    }

    public CustomerDb getById(Long id) {
        CustomerEntity customerEntity = this.entityManager.find(CustomerEntity.class, id);
        return mapper.map(customerEntity, CustomerDb.class);
    }

    @Override
    public void delete(CustomerDb customerDb) {
        if (customerDb.getId() != null) {
            CustomerEntity customerEntity = mapper.map(customerDb, CustomerEntity.class);
            entityManager.remove(entityManager
                    .contains(customerEntity) ? customerEntity : entityManager.merge(customerEntity));
        }
    }

    @Override
    public void update(Long id, CustomerDb customerDb) {
        if (customerDb.getId() != null) {
            CustomerEntity customerEntity = mapper.map(customerDb, CustomerEntity.class);
            this.entityManager.merge(customerEntity);
        }
    }

    @Override
    public List<CustomerDb> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerEntity> criteriaQuery = builder.createQuery(CustomerEntity.class);
        Root<CustomerEntity> entityRoot = criteriaQuery.from(CustomerEntity.class);
        criteriaQuery.select(entityRoot);
        List<CustomerEntity> customerEntityList = entityManager.createQuery(criteriaQuery).getResultList();

        Type listType = new TypeToken<List<CustomerDb>>() {
        }.getType();
        return mapper.map(customerEntityList, listType);
    }
}
