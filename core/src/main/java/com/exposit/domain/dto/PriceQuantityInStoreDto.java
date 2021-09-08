package com.exposit.domain.dto;

import com.exposit.domain.model.db.ProductDb;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Dto object that represents a ProductQuantityInStore.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Getter
@Setter
@ToString
public class PriceQuantityInStoreDto {

    private ProductDb productDb;
    private Double price;
    private Integer quantity;
    private String storeName;
}
