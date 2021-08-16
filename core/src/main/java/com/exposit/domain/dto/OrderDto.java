package com.exposit.domain.dto;

import com.exposit.domain.model.entity.OrderStatusEntity;
import com.exposit.domain.model.db.CustomerDb;
import com.exposit.domain.model.db.OrderItemDb;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    private Long id;
    private LocalDate dateOfOrder;
    private LocalDate dateOfDelivery;
    private Integer priceOfPurchase;
    private CustomerDb customer;
    private List<OrderItemDb> orderItemList;
    private OrderStatusEntity orderStatusEntity;

    @Min(0)
    private Long days;
}
