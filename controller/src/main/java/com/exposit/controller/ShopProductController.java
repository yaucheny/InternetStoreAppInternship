package com.exposit.controller;

import com.exposit.api.service.ShopProductService;
import com.exposit.dto.ShopProductDto;
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

import java.util.List;

@Log4j
@RestController
@RequestMapping("/shopProduct")
public class ShopProductController {

    private final ShopProductService shopProductService;
    private static final String REQUEST = "receive request: /shopProduct/ ";

    public ShopProductController(ShopProductService shopProductService) {
        this.shopProductService = shopProductService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopProductDto> getById(@PathVariable Long id) {
        log.info(REQUEST + id);
        return ResponseEntity.ok()
                .body(shopProductService.getShopProductById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<ShopProductDto>> getAll() {
        log.info(REQUEST);
        return ResponseEntity.ok().body(shopProductService.getAllShopProduct());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        shopProductService.deleteShopProduct(id);
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(String
                .format("shopProduct %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(
            @RequestBody ShopProductDto shopProductDto) {
        shopProductService.addShopProduct(shopProductDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body("new category added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,
                                         @RequestBody ShopProductDto shopProductDto) {
        shopProductService.updateShopProduct(id, shopProductDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body(String
                .format("shopProduct %s successfully updated", id));
    }
}
