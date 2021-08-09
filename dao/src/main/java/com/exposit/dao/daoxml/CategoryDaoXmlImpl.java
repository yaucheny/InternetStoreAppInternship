package com.exposit.dao.daoxml;

import com.exposit.api.dao.CategoryDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingCategoryXml;
import com.exposit.model.db.CategoryDb;

import java.util.List;

public class CategoryDaoXmlImpl extends AbstractDaoXmlImpl<CategoryDb> implements CategoryDao {

    public CategoryDaoXmlImpl() {
        List<CategoryDb> category = MarshallingCategoryXml.deSerializeCategory();
        for (CategoryDb entity : category) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(CategoryDb entity) {
        entity.setId(IdGenerator.generateCategoryId());
        repository.add(entity);
    }

    @Override
    public void saveToFile(List<CategoryDb> entity) {

    }

    private void autoLoad(CategoryDb entity) {
        repository.add(entity);
    }
}
