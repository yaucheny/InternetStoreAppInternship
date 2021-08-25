package com.exposit.dao.daoxml;

import com.exposit.api.dao.ProductDao;
import com.exposit.domain.model.db.ProductDb;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.MarshallingXml;

import java.util.List;

public class ProductDaoXmlImpl extends AbstractDaoXmlImpl<ProductDb> implements ProductDao {

    public ProductDaoXmlImpl() {
        List<ProductDb> product = MarshallingXml.deserializeXmlEntity(ProductDb.class);
        for (ProductDb entity : product) {
            this.autoLoad(entity);
        }
        IdGenerator.setProductId((long) product.size() + 1);
    }

    @Override
    public void save(ProductDb entity) {
        entity.setId(IdGenerator.generateProductId());
        repository.add(entity);
    }
}
