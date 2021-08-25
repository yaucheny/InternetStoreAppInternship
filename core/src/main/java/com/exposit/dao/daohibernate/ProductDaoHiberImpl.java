package com.exposit.dao.daohibernate;

import com.exposit.api.dao.ProductDao;
import com.exposit.domain.model.db.ProductDb;
import com.exposit.domain.model.entity.ProductEntity;
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

public class ProductDaoHiberImpl implements ProductDao {

    private static final Logger LOG = LoggerFactory.getLogger(ProductDaoHiberImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    private ModelMapper mapper;

    @Override
    @Transactional
    public void save(ProductDb productDb) {
        if (productDb.getId() == null) {
            ProductEntity productEntity = mapper.map(productDb, ProductEntity.class);
            this.entityManager.persist(productEntity);
        }
    }

    @Override
    @Transactional
    public void saveToFile(List<ProductDb> entity) {
        MarshallingJson.serializeJsonEntity(entity);
    }

    @Override
    public ProductDb getById(Long id) {
        try {
            ProductEntity productEntity = this.entityManager.find(ProductEntity.class, id);
            return mapper.map(productEntity, ProductDb.class);
        } catch (IllegalArgumentException e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id), e);
        }
    }

    @Override
    @Transactional
    public void delete(ProductDb productDb) {
        if (productDb.getId() != null) {
            ProductEntity productEntity = mapper.map(productDb, ProductEntity.class);
            entityManager.remove(entityManager
                    .contains(productEntity) ? productEntity : entityManager.merge(productEntity));
        }
    }

    @Override
    @Transactional
    public void update(Long id, ProductDb productDb) {
        if (productDb.getId() != null) {
            ProductEntity productEntity = mapper.map(productDb, ProductEntity.class);
            this.entityManager.merge(productEntity);
        }
    }

    @Override
    public List<ProductDb> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> criteriaQuery = builder.createQuery(ProductEntity.class);
        Root<ProductEntity> entityRoot = criteriaQuery.from(ProductEntity.class);
        criteriaQuery.select(entityRoot);
        List<ProductEntity> productEntityList = entityManager.createQuery(criteriaQuery).getResultList();

        Type listType = new TypeToken<List<ProductDb>>() {
        }.getType();
        return mapper.map(productEntityList, listType);
    }

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }
}
