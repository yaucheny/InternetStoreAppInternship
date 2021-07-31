package com.exposit.dao.daojson;

import com.exposit.api.dao.ProductDao;
import com.exposit.idgenerators.IdGenerator;
import com.exposit.marshelling.json.MarshallingProductJson;
import com.exposit.model.ProductEntity;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository("productjson")
public class ProductDaoJsonImpl extends AbstractDaoJsonImpl<ProductEntity>
        implements ProductDao {

    private ProductDaoJsonImpl() {
        List<ProductEntity> product = MarshallingProductJson
                .deSerializeProduct();
        for (ProductEntity entity : product) {
            this.save(entity);
        }
        IdGenerator.setProductId((long) product.size() + 1);
    }

    @Override
    public void save(ProductEntity entity) {
        entity.setId(IdGenerator.generateProductId());
        repository.add(entity);
    }
}
