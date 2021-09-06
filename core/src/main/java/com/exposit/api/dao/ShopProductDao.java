package com.exposit.api.dao;

import com.exposit.domain.model.db.ShopProductDb;

import java.util.List;

/**
 * Dao interface for{@link com/exposit/domain/model/db/ShopProductDb.java}.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public interface ShopProductDao extends GenericDao<ShopProductDb> {
    /**
     * Sorts products in shop by price.
     *
     * @author Yauheni Markevich
     */
    List<ShopProductDb> sortByPrice();

}
