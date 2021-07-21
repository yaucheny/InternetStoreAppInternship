package com.exposit.dao.daoXml;

import com.exposit.api.dao.CategoryDao;
import com.exposit.idGenerators.IdGenerator;
import com.exposit.marshelling.Xml.MarshallingCategoryXml;
import com.exposit.model.CategoryEntity;

import java.util.List;

public class CategoryDaoXmlImpl extends AbstractDaoXmlImpl<CategoryEntity> implements CategoryDao {

    private static CategoryDao instance;

    private CategoryDaoXmlImpl() {
        List<CategoryEntity> category = MarshallingCategoryXml
        .deSerializeCategory();
        for (CategoryEntity entity : category) {
  //          entity.setId(IdGenerator.generateCategoryId());
            this.save(entity);
        }
    }

    public static CategoryDao getInstance() {
        if (instance == null) {
            instance = new CategoryDaoXmlImpl();
        }
        return instance;
    }


    @Override
    public void save(CategoryEntity entity) {
        entity.setId(IdGenerator.generateCategoryId());
        repository.add(entity);
    }
}
