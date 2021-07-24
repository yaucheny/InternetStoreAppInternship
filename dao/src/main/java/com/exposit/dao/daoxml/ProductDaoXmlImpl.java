package com.exposit.dao.daoxml;

import com.exposit.api.dao.ProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingProductXml;
import com.exposit.model.ProductEntity;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ProductDaoXmlImpl extends AbstractDaoXmlImpl<ProductEntity>
        implements ProductDao {

    private static ProductDao instance;

    private ProductDaoXmlImpl() {
        List<ProductEntity> product = MarshallingProductXml
        .deSerializeProduct();
        for (ProductEntity entity : product) {
            this.save(entity);
        }
    }

    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDaoXmlImpl();
        }
        return instance;
    }

    @Override
    public void save(ProductEntity entity) {
        entity.setId(IdGenerator.generateProductId());
        repository.add(entity);
    }
}
