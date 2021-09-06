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
     * Saves List<T> entities to file.
     *
     * @param logInfoDb entity with info about result of working of updateShopProductsFromCsv() method.
     * @author Yauheni Markevich
     */
    void save(LogInfoDb logInfoDb);
}
