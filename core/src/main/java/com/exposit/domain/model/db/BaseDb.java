package com.exposit.domain.model.db;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Simple JavaBean object that represents a parent object.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@NoArgsConstructor
@Getter
@Setter
public abstract class BaseDb {
    @CsvBindByName(column = "id")
    protected Long id;
}
