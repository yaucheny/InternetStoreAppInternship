package com.exposit.controller;

import com.exposit.api.service.OrderItemService;
import com.exposit.domain.dto.OrderItemDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    private final static Logger log = LoggerFactory.getLogger(OrderItemController.class);
    private final OrderItemService orderItemService;
    private static final String REQUEST = "receive request: /orderItem/ ";

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
        return ResponseEntity.ok().body(String.format("orderItem %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(@Valid @RequestBody OrderItemDto orderItemDto) {
        orderItemService.addOrderItem(orderItemDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body("new orderItem added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody OrderItemDto orderItemDto) {
        orderItemService.updateOrderItem(id, orderItemDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body(String.format("orderItem %s successfully updated", id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveToFile() {
        orderItemService.saveOrderItemToFile();
        log.info(REQUEST);
        return ResponseEntity.ok().body("orderItems successfully saved");
    }
}
