package com.exposit.api.dao;

import com.exposit.model.db.ShopProductDb;

import java.util.List;

public interface ShopProductDao extends GenericDao<ShopProductDb> {

    void save(ShopProductDb entity);

    List<ShopProductDb> sortByPrice();

    void saveToFile(List<ShopProductDb> entity);
}
