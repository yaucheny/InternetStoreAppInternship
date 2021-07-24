package com.exposit.dao.daoxml;

import com.exposit.api.dao.CategoryDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingCategoryXml;
import com.exposit.model.CategoryEntity;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CategoryDaoXmlImpl extends AbstractDaoXmlImpl<CategoryEntity> implements CategoryDao {

    private static CategoryDao instance;

    private CategoryDaoXmlImpl() {
        List<CategoryEntity> category = MarshallingCategoryXml
        .deSerializeCategory();
        for (CategoryEntity entity : category) {
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
