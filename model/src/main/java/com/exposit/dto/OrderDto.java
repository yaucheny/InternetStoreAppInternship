package com.exposit.dto;

import com.exposit.model.CustomerEntity;
import com.exposit.model.OrderItemEntity;
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
    private CustomerEntity customer;
    private List<OrderItemEntity> orderItemList;
    @Min(0)
    private Long days;
}
