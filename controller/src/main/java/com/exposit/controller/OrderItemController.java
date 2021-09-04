package com.exposit.controller;

import com.exposit.api.service.OrderItemService;
import com.exposit.facade.config.ConfigFacade;
import com.exposit.domain.dto.OrderItemDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orderItem")
@ConditionalOnMissingBean(value = ConfigFacade.class)
public class OrderItemController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderItemController.class);
    private final OrderItemService orderItemService;
    private static final String REQUEST = "receive request: /orderItem/ ";
    private static final String REQUEST_PARAM = "receive request: /orderItem/{}";

    @ApiOperation(value = "Return orderItem by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved entity"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDto> getById(@Valid @Parameter(description = "id of orderItem")
                                                @PathVariable Long id) {
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(orderItemService.getOrderItemById(id));
    }


    @ApiOperation(value = "Return all orderItems")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/")
    public ResponseEntity<List<OrderItemDto>> getAll() {
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body(orderItemService.getAllOrderItem());
    }

    @ApiOperation(value = "Delete orderItem by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted entity"),
            @ApiResponse(code = 401, message = "You are not authorized to delete entity"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to delete is not found")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@Valid @Parameter(description = "id of orderItem")
                                             @PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("orderItem %s successfully deleted", id));
    }

    @ApiOperation(value = "Create new orderItem")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 201, message = "Successfully created new entity"),
            @ApiResponse(code = 401, message = "You are not authorized to create the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to create is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to create is not found")
    })
    @PostMapping(value = "/")
    public ResponseEntity<String> save(@Valid @RequestBody OrderItemDto orderItemDto) {
        orderItemService.addOrderItem(orderItemDto);
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body("new orderItem added");
    }

    @ApiOperation(value = "Update orderItem by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated entity"),
            @ApiResponse(code = 401, message = "You are not authorized to update the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to update is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to update is not found")
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@Valid @Parameter(description = "id of orderItem") @PathVariable Long id,
                                         @Valid @RequestBody OrderItemDto orderItemDto) {
        orderItemService.updateOrderItem(id, orderItemDto);
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("orderItem %s successfully updated", id));
    }

    @ApiOperation(value = "Save orderItems to file")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 401, message = "You are not authorized to save the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to save is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to save is not found")
    })
    @PostMapping(value = "/save")
    public ResponseEntity<String> saveToFile() {
        orderItemService.saveOrderItemToFile();
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body("orderItems successfully saved");
    }
}
