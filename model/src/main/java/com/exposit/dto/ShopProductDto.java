package com.exposit.dto;

import com.exposit.model.ProductEntity;
import com.exposit.model.StoreEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopProductDto {

    private Long id;
    private ProductEntity product;
    private Integer price;
    private Integer quantity;
    private StoreEntity store;
    private String description;
}
