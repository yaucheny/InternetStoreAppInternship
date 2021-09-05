package com.exposit.api.dao;

import com.exposit.domain.model.db.LogInfoDb;
/**
 * Dao interface for{@link com/exposit/domain/model/db/LogInfoDb.java}.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public interface LogInfoDao {

    void save(LogInfoDb logInfoDb);
}
