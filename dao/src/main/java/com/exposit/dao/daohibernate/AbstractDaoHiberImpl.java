package com.exposit.dao.daohibernate;

import com.exposit.api.dao.GenericDao;
import com.exposit.model.db.BaseDb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDaoHiberImpl<T extends BaseDb> implements GenericDao<T> {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;

    public T getById(Long id) {
        return this.entityManager.find(this.getClazz(), id);
    }

    @Override
    public void delete(T entity) {
        if (entity.getId() != null)
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Override
    public void update(Long id, T entity) {
        if (entity.getId() != null) {
            this.entityManager.merge(entity);
        }
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(this.getClazz());

        Root<T> entityRoot = criteriaQuery.from(this.getClazz());

        criteriaQuery.select(entityRoot);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public void saveOrUpdate(T entity) {
        if (entity.getId() != null) {
            this.entityManager.merge(entity);
        } else {
            this.entityManager.persist(entity);
        }
    }

    protected abstract Class<T> getClazz();
}
