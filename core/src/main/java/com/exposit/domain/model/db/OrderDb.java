package com.exposit.domain.model.db;

import com.exposit.domain.model.entity.OrderStatusEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;
/**
 * Simple JavaBean object that represents a Order.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDb extends BaseDb {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfOrder;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfDelivery;

    private Double priceOfPurchase;
    private CustomerDb customer;
    private List<OrderItemDb> orderItemList;
    private Long days;
    private OrderStatusEntity orderStatusEntity;
}
