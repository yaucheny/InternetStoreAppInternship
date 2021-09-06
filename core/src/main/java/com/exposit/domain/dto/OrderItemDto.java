package com.exposit.domain.dto;

import com.exposit.domain.model.db.ShopProductDb;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
/**
 * Dto object that represents a OrderItem.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Schema(description = "entity of orderItem")
public class OrderItemDto {

    @Min(value = 1, message = "value of id should be more than 0")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @ApiModelProperty(notes = "product of shop in order item")
    private ShopProductDb shopProduct;

    @ApiModelProperty(notes = "quantity product of shop in order item")
    @Min(value = 0, message = "quantity should me more than 0")
    private Integer quantity;
}
