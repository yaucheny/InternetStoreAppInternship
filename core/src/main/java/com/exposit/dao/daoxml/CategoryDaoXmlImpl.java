package com.exposit.dao.daoxml;

import com.exposit.api.dao.CategoryDao;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.xml.MarshallingCategoryXml;
import com.exposit.domain.model.db.CategoryDb;

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
