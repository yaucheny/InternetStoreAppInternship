package com.exposit.dao.daoxml;

import com.exposit.api.dao.ProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.xml.MarshallingProductXml;
import com.exposit.model.db.ProductDb;

import java.util.List;

public class ProductDaoXmlImpl extends AbstractDaoXmlImpl<ProductDb> implements ProductDao {

    public ProductDaoXmlImpl() {
        List<ProductDb> product = MarshallingProductXml.deSerializeProduct();
        for (ProductDb entity : product) {
            this.autoLoad(entity);
        }
    }

    @Override
    public void save(ProductDb entity) {
        entity.setId(IdGenerator.generateProductId());
        repository.add(entity);
    }

    private void autoLoad(ProductDb entity) {
        repository.add(entity);
    }
}
