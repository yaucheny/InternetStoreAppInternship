package com.exposit.controller;

import com.exposit.api.service.IStoreService;
import com.exposit.domain.dto.StoreDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store")
public class StoreController {

    private static final Logger LOG = LoggerFactory.getLogger(StoreController.class);
    private final IStoreService storeService;
    private static final String REQUEST = "receive request: /store/ ";
    private static final String REQUEST_PARAM = "receive request: /store/{}";

    @GetMapping("/{id}")
    public ResponseEntity<StoreDto> getById(@PathVariable Long id) {
        LOG.info(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(storeService.getStoreById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<StoreDto>> getAll() {
        LOG.info(REQUEST);
        return ResponseEntity.ok().body(storeService.getAllStore());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        storeService.deleteStore(id);
        LOG.info(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("store %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(@Valid @RequestBody StoreDto storeDto) {
        storeService.addStore(storeDto);
        LOG.info(REQUEST);
        return ResponseEntity.ok().body("new store added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody StoreDto storeDto) {
        storeService.updateStore(id, storeDto);
        LOG.info(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("category %s successfully updated", id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveToFile() {
        storeService.saveStoreToFile();
        LOG.info(REQUEST);
        return ResponseEntity.ok().body("stores successfully saved");
    }
}
