package com.exposit.domain.dto;

import com.exposit.domain.model.db.ProductDb;
import com.exposit.domain.model.db.StoreDb;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Schema(description = "entity of shopProduct")
public class ShopProductDto {

    @Min(value = 1, message = "value of id should be more than 0")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @ApiModelProperty(notes = "product in shop")
    private ProductDb product;

    @Min(value = 0, message = "price should be more then 0")
    @ApiModelProperty(notes = "price of product in shop")
    private Double price;

    @Min(value = 0, message = "quantity should be more than 0")
    @ApiModelProperty(notes = "quantity of product in shop")
    private Integer quantity;

    @ApiModelProperty(notes = "store of product")
    private StoreDb store;

    @NotEmpty
    @Size(min = 3, max = 100, message = "description should be more than 3 and less than 100 characters")
    @ApiModelProperty(notes = "description of product in shop")
    private String description;
}
