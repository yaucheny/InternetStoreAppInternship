package com.exposit.dao.daoxml;

import com.exposit.api.dao.CategoryDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingCategoryXml;
import com.exposit.model.CategoryEntity;

import java.util.List;

public class CategoryDaoXmlImpl
        extends AbstractDaoXmlImpl<CategoryEntity> implements CategoryDao {

    public CategoryDaoXmlImpl() {
        List<CategoryEntity> category = MarshallingCategoryXml
                .deSerializeCategory();
        for (CategoryEntity entity : category) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(CategoryEntity entity) {
        entity.setId(IdGenerator.generateCategoryId());
        repository.add(entity);
    }

    private void autoLoad(CategoryEntity entity){
        repository.add(entity);
    }
}
