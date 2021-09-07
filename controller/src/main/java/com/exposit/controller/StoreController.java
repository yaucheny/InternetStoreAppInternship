package com.exposit.controller;

import com.exposit.api.service.StoreService;
import com.exposit.facade.config.ConfigFacade;
import com.exposit.domain.dto.StoreDto;
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
/**
 * Controller for {@link com.exposit.domain.model.db.StoreDb}'s pages.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/stores")
@ConditionalOnMissingBean(value = ConfigFacade.class)
public class StoreController {

    private static final Logger LOG = LoggerFactory.getLogger(StoreController.class);
    private final StoreService storeService;
    private static final String REQUEST = "receive request: /store/ ";
    private static final String REQUEST_PARAM = "receive request: /store/{}";

    @ApiOperation(value = "Return store by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved entity"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/v1/{id}")
    public ResponseEntity<StoreDto> getById(@Valid @Parameter(description = "id of store")
                                            @PathVariable Long id) {
        LOG.info(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(storeService.getStoreById(id));
    }

    @ApiOperation(value = "Return all stores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/v1")
    public ResponseEntity<List<StoreDto>> getAll() {
        LOG.info(REQUEST);
        return ResponseEntity.ok().body(storeService.getAllStore());
    }

    @ApiOperation(value = "Delete store by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted entity"),
            @ApiResponse(code = 401, message = "You are not authorized to delete entity"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to delete is not found")
    })
    @DeleteMapping(value = "/v1/{id}")
    public ResponseEntity<String> deleteById(@Valid @Parameter(description = "id of store")
                                             @PathVariable Long id) {
        storeService.deleteStore(id);
        LOG.info(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("store %s successfully deleted", id));
    }

    @ApiOperation(value = "Create new store")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 201, message = "Successfully created new entity"),
            @ApiResponse(code = 401, message = "You are not authorized to create the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to create is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to create is not found")
    })
    @PostMapping(value = "/v1")
    public ResponseEntity<String> save(@Valid @RequestBody StoreDto storeDto) {
        storeService.addStore(storeDto);
        LOG.info(REQUEST);
        return ResponseEntity.ok().body("new store added");
    }

    @ApiOperation(value = "Update store by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated entity"),
            @ApiResponse(code = 401, message = "You are not authorized to update the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to update is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to update is not found")
    })
    @PutMapping(value = "/v1/{id}")
    public ResponseEntity<String> update(@Valid @Parameter(description = "id of store") @PathVariable Long id,
                                         @Valid @RequestBody StoreDto storeDto) {
        storeService.updateStore(id, storeDto);
        LOG.info(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("category %s successfully updated", id));
    }

    @ApiOperation(value = "Save stores to file")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 401, message = "You are not authorized to save the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to save is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to save is not found")
    })
    @PostMapping(value = "/v1/file")
    public ResponseEntity<String> saveToFile() {
        storeService.saveStoreToFile();
        LOG.info(REQUEST);
        return ResponseEntity.ok().body("stores successfully saved");
    }
}
