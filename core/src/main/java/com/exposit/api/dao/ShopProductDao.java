package com.exposit.api.dao;

import com.exposit.domain.model.db.ShopProductDb;

import java.util.List;

public interface ShopProductDao extends GenericDao<ShopProductDb> {

    List<ShopProductDb> sortByPrice();

}
