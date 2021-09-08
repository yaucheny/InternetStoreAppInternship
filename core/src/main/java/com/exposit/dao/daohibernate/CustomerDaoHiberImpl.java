package com.exposit.dao.daohibernate;

import com.exposit.api.dao.CustomerDao;
import com.exposit.domain.model.db.CustomerDb;
import com.exposit.domain.model.entity.CustomerEntity;
import com.exposit.utils.exceptions.NotFoundException;
import com.exposit.utils.marshelling.MarshallingJson;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Implementation of {@link CustomerDao} interface.
 * Implementation works with Hibernate framework and postgres database
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class CustomerDaoHiberImpl implements CustomerDao {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerDaoHiberImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    private ModelMapper mapper;


    @Override
    @Transactional
    public void save(CustomerDb customerDb) {
        if (customerDb.getId() == null) {
            CustomerEntity customerEntity = mapper.map(customerDb, CustomerEntity.class);
            this.entityManager.persist(customerEntity);
        }
    }

    @Override
    @Transactional
    public void saveToFile(List<CustomerDb> entity) {
        MarshallingJson.serializeJsonEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDb getById(Long id) {
        try {
            CustomerEntity customerEntity = this.entityManager.find(CustomerEntity.class, id);
            return mapper.map(customerEntity, CustomerDb.class);
        } catch (IllegalArgumentException e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id), e);
        }
    }

    @Override
    @Transactional
    public void delete(CustomerDb customerDb) {
        if (customerDb.getId() != null) {
            CustomerEntity customerEntity = mapper.map(customerDb, CustomerEntity.class);
            entityManager.remove(entityManager
                    .contains(customerEntity) ? customerEntity : entityManager.merge(customerEntity));
        }
    }

    @Override
    @Transactional
    public void update(Long id, CustomerDb customerDb) {
        if (customerDb.getId() != null) {
            CustomerEntity customerEntity = mapper.map(customerDb, CustomerEntity.class);
            this.entityManager.merge(customerEntity);
        }
    }

    @Override
    @Transactional(readOnly = true)
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

    @Autowired
    public void setMapper(ModelMapper mapper1) {
        this.mapper = mapper1;
    }
}
