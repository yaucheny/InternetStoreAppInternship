package com.exposit.dto;

import com.exposit.model.ProductEntity;
import com.exposit.model.StoreEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ShopProductDto {

    private Long id;
    private ProductEntity product;
    @Min(value = 0, message = "price should be more then 0")
    private Integer price;
    @Min(value = 0, message = "quantity should be more than 0")
    private Integer quantity;
    private StoreEntity store;
    @NotEmpty
    @Size(min = 3, max = 100, message = "description should be more than 3 and less than 100 characters")
    private String description;
}
