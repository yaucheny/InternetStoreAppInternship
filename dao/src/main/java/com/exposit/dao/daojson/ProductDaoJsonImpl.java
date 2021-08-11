package com.exposit.dao.daojson;

import com.exposit.api.dao.ProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingProductJson;
import com.exposit.model.db.ProductDb;

import java.util.List;

public class ProductDaoJsonImpl extends AbstractDaoJsonImpl<ProductDb> implements ProductDao {

    public ProductDaoJsonImpl() {
        List<ProductDb> product = MarshallingProductJson.deSerializeProduct();
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
