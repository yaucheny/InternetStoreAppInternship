package com.exposit.dao.daojson;

import com.exposit.api.dao.ProductDao;
import com.exposit.utils.idgenerators.IdGenerator;
import com.exposit.utils.marshelling.json.MarshallingProductJson;
import com.exposit.domain.model.db.ProductDb;

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

    @Override
    public void saveToFile(List<ProductDb> entity) {

    }

    private void autoLoad(ProductDb entity) {
        repository.add(entity);
    }
}
