package com.exposit.controller;

import com.exposit.api.service.ShopProductService;
import com.exposit.domain.dto.ShopProductDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shopProduct")
public class ShopProductController {

    private final static Logger log = LoggerFactory.getLogger(ShopProductController.class);
    private final ShopProductService shopProductService;
    private static final String REQUEST = "receive request: /shopProduct/ ";

    @GetMapping("/{id}")
    public ResponseEntity<ShopProductDto> getById(@PathVariable Long id) {
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(shopProductService.getShopProductById(id));
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
        return ResponseEntity.ok().body(String.format("shopProduct %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(
            @Valid @RequestBody ShopProductDto shopProductDto) {
        shopProductService.addShopProduct(shopProductDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body("new category added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,
                                         @Valid @RequestBody ShopProductDto shopProductDto) {
        shopProductService.updateShopProduct(id, shopProductDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body(String.format("shopProduct %s successfully updated", id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveToFile() {
        shopProductService.saveShopProductToFile();
        log.info(REQUEST);
        return ResponseEntity.ok().body("products successfully saved");
    }
}
