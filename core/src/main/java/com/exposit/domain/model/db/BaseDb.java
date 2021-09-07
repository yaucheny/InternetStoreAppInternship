package com.exposit.domain.model.db;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

/**
 * Simple JavaBean object that represents a parent object.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Data
public abstract class BaseDb {

    @CsvBindByName(column = "id")
    protected Long id;
}
