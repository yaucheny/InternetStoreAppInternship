package com.exposit.dao.daoxml;

import com.exposit.api.dao.ProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingCategoryXml;
import com.exposit.marshelling.xml.MarshallingProductXml;
import com.exposit.model.CategoryEntity;
import com.exposit.model.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoXmlImpl extends AbstractDaoXmlImpl<ProductEntity>
        implements ProductDao {

    private ProductDao productDao;

    public ProductDaoXmlImpl() {
        List<ProductEntity> category = MarshallingProductXml
                .deSerializeProduct();
        for (ProductEntity entity : category) {
            this.save(entity);
        }
    }

    @Override
    public void save(ProductEntity entity) {
        entity.setId(IdGenerator.generateProductId());
        repository.add(entity);
    }
}
