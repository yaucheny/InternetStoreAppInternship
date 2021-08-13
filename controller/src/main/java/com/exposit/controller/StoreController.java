package com.exposit.controller;

import com.exposit.api.service.IStoreService;
import com.exposit.dto.StoreDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/store")
public class StoreController {

    private final IStoreService storeService;
    private static final String REQUEST = "receive request: /store/ ";

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
        return ResponseEntity.ok().body(String.format("store %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(@Valid @RequestBody StoreDto storeDto) {
        storeService.addStore(storeDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body("new store added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody StoreDto storeDto) {
        storeService.updateStore(id, storeDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body(String.format("category %s successfully updated", id));
    }
}
