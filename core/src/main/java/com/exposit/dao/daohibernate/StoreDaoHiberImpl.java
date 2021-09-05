package com.exposit.dao.daohibernate;

import com.exposit.api.dao.StoreDao;
import com.exposit.domain.model.db.StoreDb;
import com.exposit.domain.model.entity.StoreEntity;
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
 * Implementation of {@link StoreDao} interface.
 * Implementation works with Hibernate framework and postgres database
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class StoreDaoHiberImpl implements StoreDao {

    private static final Logger LOG = LoggerFactory.getLogger(StoreDaoHiberImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    private ModelMapper mapper;

    @Override
    @Transactional
    public void save(StoreDb storeDb) {
        if (storeDb.getId() == null) {
            StoreEntity storeEntity = mapper.map(storeDb, StoreEntity.class);
            this.entityManager.persist(storeEntity);
        }
    }

    @Override
    @Transactional
    public void saveToFile(List<StoreDb> entity) {
        MarshallingJson.serializeJsonEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public StoreDb getById(Long id) {
        try {
            StoreEntity storeEntity = this.entityManager.find(StoreEntity.class, id);
            return mapper.map(storeEntity, StoreDb.class);
        } catch (IllegalArgumentException e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id), e);
        }
    }

    @Override
    @Transactional
    public void delete(StoreDb storeDb) {
        if (storeDb.getId() != null) {
            StoreEntity storeEntity = mapper.map(storeDb, StoreEntity.class);
            entityManager.remove(entityManager
                    .contains(storeEntity) ? storeEntity : entityManager.merge(storeEntity));
        }
    }

    @Override
    @Transactional
    public void update(Long id, StoreDb storeDb) {
        if (storeDb.getId() != null) {
            StoreEntity storeEntity = mapper.map(storeDb, StoreEntity.class);
            this.entityManager.merge(storeEntity);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<StoreDb> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StoreEntity> criteriaQuery = builder.createQuery(StoreEntity.class);
        Root<StoreEntity> entityRoot = criteriaQuery.from(StoreEntity.class);
        criteriaQuery.select(entityRoot);
        List<StoreEntity> storeEntityList = entityManager.createQuery(criteriaQuery).getResultList();

        Type listType = new TypeToken<List<StoreDb>>() {
        }.getType();
        return mapper.map(storeEntityList, listType);
    }

    @Autowired
    public void setMapper(ModelMapper mapper1) {
        this.mapper = mapper1;
    }
}
