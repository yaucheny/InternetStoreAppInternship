package com.exposit.dto;

import com.exposit.model.db.ShopProductDb;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class OrderItemDto {

    private Long id;
    private ShopProductDb shopProduct;
    @Min(value = 0, message = "quantity should me more than 0")
    private Integer quantity;
}
