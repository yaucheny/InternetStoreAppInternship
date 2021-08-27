package com.exposit.controller;

import com.exposit.api.service.ProductService;
import com.exposit.domain.dto.ProductDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private static final String REQUEST = "receive request: /product/ ";
    private static final String REQUEST_PARAM = "receive request: /product/{}";

    @ApiOperation(value = "Return product by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved entity"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@Valid @Parameter(description = "id of product")
                                              @PathVariable Long id) {
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @ApiOperation(value = "Return all products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAll() {
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @ApiOperation(value = "Delete product by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted entity"),
            @ApiResponse(code = 401, message = "You are not authorized to delete entity"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to delete is not found")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@Valid @Parameter(description = "id of product")
                                             @PathVariable Long id) {
        productService.deleteProduct(id);
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("product %s successfully deleted", id));
    }

    @ApiOperation(value = "Create new product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 201, message = "Successfully created new entity"),
            @ApiResponse(code = 401, message = "You are not authorized to create the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to create is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to create is not found")
    })
    @PostMapping(value = "/")
    public ResponseEntity<String> save(@Valid @RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body("new product added");
    }

    @ApiOperation(value = "Update product by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated entity"),
            @ApiResponse(code = 401, message = "You are not authorized to update the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to update is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to update is not found")
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@Valid @Parameter(description = "id of product") @PathVariable Long id,
                                         @Valid @RequestBody ProductDto productDto) {
        productService.updateProduct(id, productDto);
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("product %s successfully updated", id));
    }

    @ApiOperation(value = "Save products to file")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 401, message = "You are not authorized to save the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to save is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to save is not found")
    })
    @PostMapping(value = "/save")
    public ResponseEntity<String> saveToFile() {
        productService.saveProductToFile();
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body("products successfully saved");
    }
}
