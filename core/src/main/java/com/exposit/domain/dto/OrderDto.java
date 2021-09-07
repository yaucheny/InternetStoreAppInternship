package com.exposit.domain.dto;

import com.exposit.domain.model.db.CustomerDb;
import com.exposit.domain.model.db.OrderItemDb;
import com.exposit.domain.model.entity.OrderStatusEntity;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * Dto object that represents a order.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Schema(description = "entity of order")
public class OrderDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate dateOfOrder;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate dateOfDelivery;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Double priceOfPurchase;

    @NotNull
    @ApiModelProperty(notes = " customer of order")
    private CustomerDb customer;

    @NotNull
    @ApiModelProperty(notes = "order items included in order")
    private List<OrderItemDb> orderItemList;

    @ApiModelProperty(notes = "status of order")
    private OrderStatusEntity orderStatusEntity;

    @Min(value = 0, message = "amount of days should be more 0")
    @ApiModelProperty(notes = "amount days to deliver an order")
    private Long days;
}
