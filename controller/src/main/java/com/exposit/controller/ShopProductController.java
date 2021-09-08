package com.exposit.controller;

import com.exposit.api.service.ShopProductService;
import com.exposit.facade.config.ConfigFacade;
import com.exposit.domain.dto.PriceQuantityInStoreDto;
import com.exposit.domain.dto.ShopProductDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for {@link com.exposit.domain.model.db.ShopProductDb}'s pages.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/shopProducts")
@ConditionalOnMissingBean(value = ConfigFacade.class)
public class ShopProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ShopProductController.class);
    private final ShopProductService shopProductService;
    private static final String REQUEST = "receive request: /shopProduct/ ";
    private static final String REQUEST_PARAM = "receive request: /shopProduct/{}";

    @ApiOperation(value = "Return shopProduct by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved entity"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/v1/{id}")
    public ResponseEntity<ShopProductDto> getById(@Valid @Parameter(description = "id of shopProduct")
                                                  @PathVariable Long id) {
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(shopProductService.getShopProductById(id));
    }

    @ApiOperation(value = "Return all shopProducts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/v1")
    public ResponseEntity<List<ShopProductDto>> getAll() {
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body(shopProductService.getAllShopProduct());
    }

    @ApiOperation(value = "Delete shopProduct by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted entity"),
            @ApiResponse(code = 401, message = "You are not authorized to delete entity"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to delete is not found")
    })
    @DeleteMapping(value = "/v1/{id}")
    public ResponseEntity<String> deleteById(@Valid @Parameter(description = "id of shopProduct")
                                             @PathVariable Long id) {
        shopProductService.deleteShopProduct(id);
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("shopProduct %s successfully deleted", id));
    }


    @ApiOperation(value = "Create new shopProduct")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 201, message = "Successfully created new entity"),
            @ApiResponse(code = 401, message = "You are not authorized to create the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to create is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to create is not found")
    })
    @PostMapping(value = "/v1")
    public ResponseEntity<String> save(
            @Valid @RequestBody ShopProductDto shopProductDto) {
        shopProductService.addShopProduct(shopProductDto);
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body("new category added");
    }

    @ApiOperation(value = "Update shopProduct by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated entity"),
            @ApiResponse(code = 401, message = "You are not authorized to update the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to update is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to update is not found")
    })
    @PutMapping(value = "/v1/{id}")
    public ResponseEntity<String> update(@Valid @Parameter(description = "id of shopProduct") @PathVariable Long id,
                                         @Valid @RequestBody ShopProductDto shopProductDto) {
        shopProductService.updateShopProduct(id, shopProductDto);
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("shopProduct %s successfully updated", id));
    }

    @ApiOperation(value = "Save shopProducts to file")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 401, message = "You are not authorized to save the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to save is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to save is not found")
    })
    @PostMapping(value = "/v1/file")
    public ResponseEntity<String> saveToFile() {
        shopProductService.saveShopProductToFile();
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body("products successfully saved");
    }

    @ApiOperation(value = "Sort products in shop by price")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 401, message = "You are not authorized to sort the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to sort is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to sort is not found")
    })
    @GetMapping(value = "/v1/price")
    public ResponseEntity<List<ShopProductDto>> sortByPrice() {
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body(shopProductService.sortByPrice());
    }

    @ApiOperation(value = "Get products in shop by category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 401, message = "You are not authorized to get the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to get is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to get is not found")
    })
    @GetMapping("/v1/category")
    public ResponseEntity<List<ShopProductDto>> getProductsFromCategory(
            @Parameter(description = "name of category of product")
            @RequestParam(value = "name") String name) {
        LOG.debug(REQUEST_PARAM, name);
        return ResponseEntity.ok().body(shopProductService.getGoodsFromCategory(name));
    }

    @ApiOperation(value = "Get price and quantity of products in store")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 401, message = "You are not authorized to get the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to get is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to get is not found")
    })
    @GetMapping(value = "/v1/store")
    public ResponseEntity<List<PriceQuantityInStoreDto>> infoAboutPriceQuantityInStore(
            @Parameter(description = "name of store")
            @RequestParam(value = "name") String name) {
        LOG.debug(REQUEST_PARAM + "/store", name);
        return ResponseEntity.ok().body(shopProductService.infoAboutPriceQuantityInStore(name));
    }

    @ApiOperation(value = "Get products by one attribute")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 401, message = "You are not authorized to get the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to get is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to get is not found")
    })
    @GetMapping(value = "/v1/attribute/one")
    public ResponseEntity<List<ShopProductDto>> getByOneAttribute(
            @Parameter(description = "name of field of shopProduct")
            @RequestParam(value = "attribute") String attrib1,
            @Parameter(description = "value of field attribute1 of shopProduct")
            @RequestParam(value = "value") String val1) {
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body(shopProductService
                .findByOneAttribute(val1, attrib1));
    }

    @ApiOperation(value = "Get products by two attributes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 401, message = "You are not authorized to get the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to get is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to get is not found")})
    @GetMapping(value = "/v1/attribute/two")
    public ResponseEntity<List<ShopProductDto>> getByTwoAttribute(
            @Parameter(description = "name of field of shopProduct")
            @RequestParam(value = "attribute1") String attrib1,
            @Parameter(description = "value of field attribute1 of shopProduct")
            @RequestParam(value = "value1") String val1,
            @Parameter(description = "name of field of shopProduct")
            @RequestParam(value = "attribute2") String attrib2,
            @Parameter(description = "value of field attribute2 of shopProduct")
            @RequestParam(value = "value2") String val2) {
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body(shopProductService.findByTwoAttribute(val1, attrib1, val2, attrib2));
    }
}
