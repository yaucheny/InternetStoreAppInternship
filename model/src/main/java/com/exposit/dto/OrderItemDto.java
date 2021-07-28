package com.exposit.dto;

import com.exposit.model.ShopProductEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {

    private Long id;
    private ShopProductEntity shopProduct;
    private Integer quantity;
}
