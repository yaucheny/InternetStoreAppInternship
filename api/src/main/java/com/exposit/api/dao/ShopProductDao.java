package com.exposit.api.dao;

import com.exposit.model.ShopProductEntity;

import java.util.List;

public interface ShopProductDao extends GenericDao<ShopProductEntity> {

    void save(ShopProductEntity entity);

    List<ShopProductEntity> sortByPrice();
}
