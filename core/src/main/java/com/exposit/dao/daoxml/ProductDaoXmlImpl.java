package com.exposit.dao.daoxml;

import com.exposit.api.dao.ProductDao;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.xml.MarshallingProductXml;
import com.exposit.domain.model.db.ProductDb;

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

    @Override
    public void saveToFile(List<ProductDb> entity) {

    }

    private void autoLoad(ProductDb entity) {
        repository.add(entity);
    }
}
