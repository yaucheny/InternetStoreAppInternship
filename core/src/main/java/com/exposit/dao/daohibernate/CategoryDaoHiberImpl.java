package com.exposit.dao.daohibernate;

import com.exposit.api.dao.CategoryDao;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.domain.model.entity.CategoryEntity;
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
 * Implementation of {@link CategoryDao} interface.
 * Implementation works with Hibernate framework and postgres database
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class CategoryDaoHiberImpl implements CategoryDao {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryDaoHiberImpl.class);
    private static final String GET_BY_ID_ERROR_LOG = "can not find an entity by id: {}";
    private static final String GET_BY_ID_ERROR_EXCEPTION = "can not find an entity by id: %s";

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    private ModelMapper mapper;

    @Override
    @Transactional
    public void save(CategoryDb categoryDb) {
        if (categoryDb.getId() == null) {
            CategoryEntity categoryEntity = mapper.map(categoryDb, CategoryEntity.class);
            if (categoryDb.getParentId() != null) {
                CategoryEntity parent = this.entityManager.find(CategoryEntity.class, categoryDb.getParentId());
                categoryEntity.setParent(parent);
            }
            this.entityManager.persist(categoryEntity);
        }
    }

    @Override
    @Transactional
    public void saveToFile(List<CategoryDb> entity) {
        MarshallingJson.serializeJsonEntity(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDb getById(Long id) {
        try {
            CategoryEntity categoryEntity = this.entityManager.find(CategoryEntity.class, id);
            return mapper.map(categoryEntity, CategoryDb.class);
        } catch (IllegalArgumentException e) {
            LOG.error(GET_BY_ID_ERROR_LOG, id);
            throw new NotFoundException(String.format(GET_BY_ID_ERROR_EXCEPTION, id), e);
        }
    }

    @Override
    @Transactional
    public void delete(CategoryDb categoryDb) {
        if (categoryDb.getId() != null) {
            CategoryEntity categoryEntity = mapper.map(categoryDb, CategoryEntity.class);
            entityManager.remove(entityManager
                    .contains(categoryEntity) ? categoryEntity : entityManager.merge(categoryEntity));
        }
    }

    @Override
    @Transactional
    public void update(Long id, CategoryDb categoryDb) {
        if (categoryDb.getId() != null) {
            CategoryEntity categoryEntity = mapper.map(categoryDb, CategoryEntity.class);
            this.entityManager.merge(categoryEntity);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDb> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CategoryEntity> criteriaQuery = builder.createQuery(CategoryEntity.class);
        Root<CategoryEntity> entityRoot = criteriaQuery.from(CategoryEntity.class);
        criteriaQuery.select(entityRoot);
        List<CategoryEntity> categoryEntityList = entityManager.createQuery(criteriaQuery).getResultList();

        Type listType = new TypeToken<List<CategoryDb>>() {
        }.getType();
        return mapper.map(categoryEntityList, listType);
    }

    @Autowired
    public void setMapper(ModelMapper mapper1) {
        this.mapper = mapper1;
    }
}
