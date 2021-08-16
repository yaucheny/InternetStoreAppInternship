package com.exposit.controller;

import com.exposit.api.service.OrderService;
import com.exposit.domain.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private static final String REQUEST = "receive request: /order/ ";

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable Long id) {
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(orderService.getOrderById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderDto>> getAll() {
        log.info(REQUEST);
        return ResponseEntity.ok().body(orderService.getAllOrder());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@Valid @PathVariable Long id) {
        orderService.deleteOrder(id);
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(String.format("order %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(@Valid @RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body("new order added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        orderService.updateOrder(id, orderDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body(String.format("order %s successfully updated", id));
    }
}
