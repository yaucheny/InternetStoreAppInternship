package com.exposit.controller;

import com.exposit.api.service.OrderItemService;
import com.exposit.dto.OrderItemDto;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;
import java.util.List;

@Log4j
@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    private final OrderItemService orderItemService;
    private static final String REQUEST = "receive request: /orderItem/ ";

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDto> getById(@PathVariable Long id) {
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(orderItemService.getOrderItemById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderItemDto>> getAll() {
        log.info(REQUEST);
        return ResponseEntity.ok().body(orderItemService.getAllOrderItem());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(String
                .format("orderItem %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(@Valid @RequestBody OrderItemDto orderItemDto) {
        orderItemService.addOrderItem(orderItemDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body("new orderItem added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,
                                         @Valid @RequestBody OrderItemDto orderItemDto) {
        orderItemService.updateOrderItem(id, orderItemDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body(String
                .format("orderItem %s successfully updated", id));
    }
}
