package com.exposit.controller;

import com.exposit.api.service.IStoreService;
import com.exposit.dto.StoreDto;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/store")
public class StoreController {

    private final IStoreService storeService;
    private static final String REQUEST = "receive request: /store/ ";

    @Autowired
    public StoreController(IStoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDto> getById(@PathVariable Long id) {
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(storeService.getStoreById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<StoreDto>> getAll() {
        log.info(REQUEST);
        return ResponseEntity.ok().body(storeService.getAllStore());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        storeService.deleteStore(id);
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(String
                .format("store %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(@RequestBody StoreDto storeDto) {
        storeService.addStore(storeDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body("new store added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,
                                         @RequestBody StoreDto storeDto) {
        storeService.updateStore(id, storeDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body(String
                .format("category %s successfully updated", id));
    }
}
