package com.exposit.domain.model.db;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Simple JavaBean object that represents a LogInfo.
 * This object is used to save info about details of working method updateShopProductsFromCsv()
 * {@link com.exposit.service.ShopProductServiceImpl} to database.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LogInfoDb extends BaseDb {

    private String path;
    private Long workTime;
    private Long numberErrors;
    private Long numberUpdates;
}
