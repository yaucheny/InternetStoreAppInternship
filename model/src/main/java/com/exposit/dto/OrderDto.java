package com.exposit.dto;

import com.exposit.model.db.CustomerDb;
import com.exposit.model.db.OrderItemDb;
import com.exposit.model.db.OrderStatusDb;
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
    private OrderStatusDb orderStatusDb;

    @Min(0)
    private Long days;
}
