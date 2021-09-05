package com.exposit.dao.daoxml;

import com.exposit.api.dao.CategoryDao;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingXml;

import java.util.List;
/**
 * Implementation of {@link CategoryDao} interface.
 * Implementation works with Jackson API and xml format files
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class CategoryDaoXmlImpl extends AbstractDaoXmlImpl<CategoryDb> implements CategoryDao {

    public CategoryDaoXmlImpl() {
        List<CategoryDb> category = MarshallingXml.deserializeXmlEntity(CategoryDb.class);
        for (CategoryDb entity : category) {
            this.autoLoad(entity);
        }
        IdGenerator.setCategoryId((long) category.size() + 1);
    }

    @Override
    public void save(CategoryDb entity) {
        entity.setId(IdGenerator.generateCategoryId());
        repository.add(entity);
    }
}
