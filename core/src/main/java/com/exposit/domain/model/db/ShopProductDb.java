package com.exposit.domain.model.db;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * Simple JavaBean object that represents a ShopProduct.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ShopProductDb extends BaseDb {

    private Integer quantity;
    private StoreDb store;
    private ProductDb product;

    @CsvBindByName(column = "price")
    private Double price;

    @CsvBindByName(column = "description")
    private String description;
}
