package com.exposit.domain.dto;

import com.exposit.domain.model.entity.OrderStatusEntity;
import com.exposit.domain.model.db.CustomerDb;
import com.exposit.domain.model.db.OrderItemDb;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Schema(description = "entity of order")
public class OrderDto {

    @Min(value = 1, message = "value of id should be more than 0")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate dateOfOrder;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate dateOfDelivery;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Double priceOfPurchase;

    @ApiModelProperty(notes = " customer of order")
    private CustomerDb customer;

    @ApiModelProperty(notes = "order items included in order")
    private List<OrderItemDb> orderItemList;

    @ApiModelProperty(notes = "status of order")
    private OrderStatusEntity orderStatusEntity;

    @Min(0)
    @ApiModelProperty(notes = "amount days to deliver an order")
    private Long days;
}
