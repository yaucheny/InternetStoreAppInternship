package com.exposit.dao.daoxml;

import com.exposit.api.dao.ProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingProductXml;
import com.exposit.model.ProductEntity;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
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
