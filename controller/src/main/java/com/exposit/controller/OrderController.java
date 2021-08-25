package com.exposit.controller;

import com.exposit.api.service.OrderService;
import com.exposit.domain.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;
    private static final String REQUEST = "receive request: /order/ ";
    private static final String REQUEST_PARAM = "receive request: /order/{}";

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable Long id) {
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(orderService.getOrderById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderDto>> getAll() {
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body(orderService.getAllOrder());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@Valid @PathVariable Long id) {
        orderService.deleteOrder(id);
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("order %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(@Valid @RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body("new order added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        orderService.updateOrder(id, orderDto);
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("order %s successfully updated", id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveToFile() {
        orderService.saveOrderToFile();
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body("orders successfully saved");
    }
}
