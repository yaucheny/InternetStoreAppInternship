package com.exposit.controller;

import com.exposit.api.service.ProductService;
import com.exposit.dto.ProductDto;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

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
}
