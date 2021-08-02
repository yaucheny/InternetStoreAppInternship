package com.exposit.dao.daojson;

import com.exposit.api.dao.ProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingProductJson;
import com.exposit.model.ProductEntity;

import java.util.List;

public class ProductDaoJsonImpl extends AbstractDaoJsonImpl<ProductEntity>
        implements ProductDao {

    public ProductDaoJsonImpl() {
        List<ProductEntity> product = MarshallingProductJson
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
