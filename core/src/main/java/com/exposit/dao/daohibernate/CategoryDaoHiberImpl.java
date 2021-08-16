package com.exposit.dao.daohibernate;

import com.exposit.api.dao.CategoryDao;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.domain.model.entity.CategoryEntity;
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
public class CategoryDaoHiberImpl implements CategoryDao {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
    @Autowired
    private ModelMapper mapper;
    private List<CategoryEntity> repository = new ArrayList<>();

    @Override
    public void save(CategoryDb categoryDb) {
        if (categoryDb.getId() == null) {
            CategoryEntity categoryEntity = mapper.map(categoryDb, CategoryEntity.class);
            this.entityManager.persist(categoryEntity);
        }
    }

    @Override
    public void saveToFile(List<CategoryDb> entity) {

    }

    public CategoryDb getById(Long id) {
        CategoryEntity categoryEntity = this.entityManager.find(CategoryEntity.class, id);
        return mapper.map(categoryEntity, CategoryDb.class);
    }

    @Override
    public void delete(CategoryDb categoryDb) {
        if (categoryDb.getId() != null) {
            CategoryEntity categoryEntity = mapper.map(categoryDb, CategoryEntity.class);
            entityManager.remove(entityManager
                    .contains(categoryEntity) ? categoryEntity : entityManager.merge(categoryEntity));
        }
    }

    @Override
    public void update(Long id, CategoryDb categoryDb) {
        if (categoryDb.getId() != null) {
            CategoryEntity categoryEntity = mapper.map(categoryDb, CategoryEntity.class);
            this.entityManager.merge(categoryEntity);
        }
    }

    @Override
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
}
