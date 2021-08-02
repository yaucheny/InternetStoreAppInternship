package com.exposit.dao.daoxml;

import com.exposit.api.dao.ProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingProductXml;
import com.exposit.model.ProductEntity;

import java.util.List;

public class ProductDaoXmlImpl extends AbstractDaoXmlImpl<ProductEntity>
        implements ProductDao {

    public ProductDaoXmlImpl() {
        List<ProductEntity> product = MarshallingProductXml
                .deSerializeProduct();
        for (ProductEntity entity : product) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(ProductEntity entity) {
        entity.setId(IdGenerator.generateProductId());
        repository.add(entity);
    }

    private void autoLoad(ProductEntity entity){
        repository.add(entity);
    }
}
