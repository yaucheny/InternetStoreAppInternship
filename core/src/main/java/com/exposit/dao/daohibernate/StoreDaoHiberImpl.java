package com.exposit.dao.daohibernate;

import com.exposit.api.dao.StoreDao;
import com.exposit.domain.model.db.StoreDb;
import com.exposit.domain.model.entity.StoreEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@Transactional
public class StoreDaoHiberImpl implements StoreDao {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
    private List<StoreEntity> repository = new ArrayList<>();

    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(StoreDb storeDb) {
        if (storeDb.getId() == null) {
            StoreEntity storeEntity = mapper.map(storeDb, StoreEntity.class);
            this.entityManager.persist(storeEntity);
        }
    }

    @Override
    public void saveToFile(List<StoreDb> storeDbList) {

    }

    public StoreDb getById(Long id) {
        StoreEntity storeEntity = this.entityManager.find(StoreEntity.class, id);
        return mapper.map(storeEntity, StoreDb.class);
    }

    @Override
    public void delete(StoreDb storeDb) {
        if (storeDb.getId() != null) {
            StoreEntity storeEntity = mapper.map(storeDb, StoreEntity.class);
            entityManager.remove(entityManager
                    .contains(storeEntity) ? storeEntity : entityManager.merge(storeEntity));
        }
    }

    @Override
    public void update(Long id, StoreDb storeDb) {
        if (storeDb.getId() != null) {
            StoreEntity storeEntity = mapper.map(storeDb, StoreEntity.class);
            this.entityManager.merge(storeEntity);
        }
    }

    @Override
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
}
