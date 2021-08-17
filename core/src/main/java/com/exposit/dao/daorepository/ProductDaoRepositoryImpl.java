package com.exposit.dao.daorepository;

import com.exposit.api.dao.ProductDao;
import com.exposit.domain.model.db.ProductDb;

import java.util.List;

public class ProductDaoRepositoryImpl implements ProductDao {
    @Override
    public void save(ProductDb entity) {

    }

    @Override
    public void saveToFile(List<ProductDb> entity) {

    }

    @Override
    public ProductDb getById(Long id) {
        return null;
    }

    @Override
    public void delete(ProductDb entity) {

    }

    @Override
    public void update(Long id, ProductDb entity) {

    }

    @Override
    public List<ProductDb> getAll() {
        return null;
    }
}
