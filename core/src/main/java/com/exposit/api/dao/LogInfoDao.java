package com.exposit.api.dao;

import com.exposit.domain.model.db.LogInfoDb;

/**
 * Dao interface for{@link com/exposit/domain/model/db/LogInfoDb.java}.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public interface LogInfoDao {
    /**
     * Saves entities created while perform update entities with info of csv files.
     *
     * @param logInfoDb entity with info about result of working of updateShopProductsFromCsv() method.
     * @author Yauheni Markevich
     * @see com.exposit.api.service.ShopProductService#updateShopProductsFromCsv()
     */
    void save(LogInfoDb logInfoDb);
}
