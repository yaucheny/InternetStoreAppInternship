package com.exposit.dao.daohibernate;

import com.exposit.api.dao.ShopProductDao;
import com.exposit.domain.model.db.ShopProductDb;
import com.exposit.domain.model.entity.ShopProductEntity;
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

public class ShopProductDaoHiberImpl implements ShopProductDao {

    private static final Logger LOG = LoggerFactory.getLogger(ShopProductDaoHiberImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    private ModelMapper mapper;

    @Override
    @Transactional
    public void save(ShopProductDb shopProductDb) {
        if (shopProductDb.getId() == null) {
            ShopProductEntity customerEntity = mapper.map(shopProductDb, ShopProductEntity.class);
            this.entityManager.persist(customerEntity);
        }
    }

    @Override
    @Transactional
    public List<ShopProductDb> sortByPrice() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ShopProductEntity> query = builder.createQuery(ShopProductEntity.class);
        Root<ShopProductEntity> root = query.from(ShopProductEntity.class);

        query.orderBy(builder.asc(root.get("price")));
        List<ShopProductEntity> shopProductEntityList = entityManager.createQuery(query).getResultList();
        Type listType = new TypeToken<List<ShopProductDb>>() {
        }.getType();
        return mapper.map(shopProductEntityList, listType);
    }

    @Override
    @Transactional
    public void saveToFile(List<ShopProductDb> entity) {
        MarshallingJson.serializeJsonEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public ShopProductDb getById(Long id) {
        try {
            ShopProductEntity shopProductEntity = this.entityManager.find(ShopProductEntity.class, id);
            return mapper.map(shopProductEntity, ShopProductDb.class);
        } catch (IllegalArgumentException e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id), e);
        }
    }

    @Override
    @Transactional
    public void delete(ShopProductDb shopProductDb) {
        if (shopProductDb.getId() != null) {
            ShopProductEntity customerEntity = mapper.map(shopProductDb, ShopProductEntity.class);
            entityManager.remove(entityManager
                    .contains(customerEntity) ? customerEntity : entityManager.merge(customerEntity));
        }
    }

    @Override
    @Transactional
    public void update(Long id, ShopProductDb shopProductDb) {
        if (shopProductDb.getId() != null) {
            ShopProductEntity shopProductEntity = mapper.map(shopProductDb, ShopProductEntity.class);
            this.entityManager.merge(shopProductEntity);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShopProductDb> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ShopProductEntity> criteriaQuery = builder.createQuery(ShopProductEntity.class);
        Root<ShopProductEntity> entityRoot = criteriaQuery.from(ShopProductEntity.class);
        criteriaQuery.select(entityRoot);
        List<ShopProductEntity> shopProductEntityList = entityManager.createQuery(criteriaQuery).getResultList();

        Type listType = new TypeToken<List<ShopProductDb>>() {
        }.getType();
        return mapper.map(shopProductEntityList, listType);
    }

    @Autowired
    public void setMapper(ModelMapper mapper1) {
        this.mapper = mapper1;
    }
}
