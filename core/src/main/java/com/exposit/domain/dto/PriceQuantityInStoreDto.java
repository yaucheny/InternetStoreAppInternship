package com.exposit.domain.dto;

import com.exposit.domain.model.db.ProductDb;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceQuantityInStoreDto {

    private ProductDb productDb;
    private Double price;
    private Integer quantity;
    private String storeName;
}
