package com.exposit.domain.model.db;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class BaseDb {
    @CsvBindByName(column = "id")
    protected Long id;
}
