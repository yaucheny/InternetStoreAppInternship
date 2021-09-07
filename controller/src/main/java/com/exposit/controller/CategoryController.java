package com.exposit.controller;

import com.exposit.api.service.CategoryService;
import com.exposit.domain.dto.CategoryDto;
import com.exposit.facade.config.ConfigFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for {@link com.exposit.domain.model.db.CategoryDb}'s pages.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
@Api(value = "Categories of online store")
@ConditionalOnMissingBean(value = ConfigFacade.class)
public class CategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);
    private static final String REQUEST = "receive request: /category/ ";
    private static final String REQUEST_PARAM = "receive request: /category/{}";
    private final CategoryService categoryService;

    @ApiOperation(value = "Return category by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved entity"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/v1/{id}")
    public ResponseEntity<CategoryDto> getById(@Valid @Parameter(description = "id of category")
                                               @PathVariable Long id) {
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }

    @ApiOperation(value = "Return all categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/v1")
    public ResponseEntity<List<CategoryDto>> getAll() {
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body(categoryService.getAllCategory());
    }

    @ApiOperation(value = "Delete category by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted entity"),
            @ApiResponse(code = 401, message = "You are not authorized to delete entity"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to delete is not found")
    })
    @DeleteMapping(value = "/v1/{id}")
    public ResponseEntity<String> deleteById(@Valid @Parameter(description = "id of category")
                                             @PathVariable Long id) {
        categoryService.deleteCategory(id);
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("category %s successfully deleted", id));
    }

    @ApiOperation(value = "Create new category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 201, message = "Successfully created new entity"),
            @ApiResponse(code = 401, message = "You are not authorized to create the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to create is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to create is not found")
    })
    @PostMapping(value = "/v1")
    public ResponseEntity<String> save(@Valid @RequestBody CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body("new category added");
    }

    @ApiOperation(value = "Update category by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated entity"),
            @ApiResponse(code = 401, message = "You are not authorized to update the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to update is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to update is not found")
    })
    @PutMapping(value = "/v1/{id}")
    public ResponseEntity<String> update(@Valid @Parameter(description = "id of category") @PathVariable Long id,
                                         @Valid @RequestBody CategoryDto categoryDto) {
        categoryService.updateCategory(id, categoryDto);
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("category %s successfully updated", id));
    }

    @ApiOperation(value = "Save categories to file")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 401, message = "You are not authorized to save the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to save is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to save is not found")
    })
    @PostMapping(value = "/v1/file")
    public ResponseEntity<String> saveToFile() {
        categoryService.saveCategoryToFile();
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body("categories successfully saved");
    }
}
