package com.exposit.domain.model.db;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * Simple JavaBean object that represents a Store.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StoreDb extends BaseDb {

    private String name;
    private String internetPage;
    private String phoneNumber;
}
