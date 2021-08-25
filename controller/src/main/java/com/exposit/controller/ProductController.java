package com.exposit.controller;

import com.exposit.api.service.ProductService;
import com.exposit.domain.dto.ProductDto;
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

    private final static Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private static final String REQUEST = "receive request: /product/";

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id) {
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAll() {
        log.info(REQUEST);
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        productService.deleteProduct(id);
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(String.format("product %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(@Valid @RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body("new product added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody ProductDto productDto) {
        productService.updateProduct(id, productDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body(String.format("product %s successfully updated", id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveToFile() {
        productService.saveProductToFile();
        log.info(REQUEST);
        return ResponseEntity.ok().body("products successfully saved");
    }
}
