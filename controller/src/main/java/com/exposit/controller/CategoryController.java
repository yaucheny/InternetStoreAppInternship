package com.exposit.controller;


import com.exposit.api.service.CategoryService;
import com.exposit.dto.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j
@RestController
@RequestMapping("/category")
@Api(value = "Categories of online store", description = "Operations pertaining to category in online store")
public class CategoryController {

    private static final String REQUEST = "receive request: /category/";
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "Return category by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved entity"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
     @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDto> getById(@Valid @PathVariable Long id) {
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }

    @ApiOperation(value = "Return all categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/")
    public ResponseEntity<List<CategoryDto>> getAll() {
        log.info(REQUEST);
        return ResponseEntity.ok().body(categoryService.getAllCategory());
    }

    @ApiOperation(value = "Delete category by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted entity"),
            @ApiResponse(code = 401, message = "You are not authorized to delete entity"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to delete is not found")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@Valid @PathVariable Long id) {
        categoryService.deleteCategory(id);
        log.info(REQUEST + id);
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
    @PostMapping(value = "/")
    public ResponseEntity<String> save(@Valid @RequestBody CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body("new category added");
    }

    @ApiOperation(value = "Update category by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated entity"),
            @ApiResponse(code = 401, message = "You are not authorized to update the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to update is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to update is not found")
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody CategoryDto categoryDto) {
        categoryService.updateCategory(id, categoryDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body(String.format("category %s successfully updated", id));
    }

    @ApiOperation(value = "Save categories to file")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed request"),
            @ApiResponse(code = 201, message = "Successfully created new entity"),
            @ApiResponse(code = 401, message = "You are not authorized to create the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to create is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to create is not found")
    })
    @PostMapping(value = "/save")
    public ResponseEntity<String> saveToFile() {
        categoryService.saveCategoryToFile();
        log.info(REQUEST);
        return ResponseEntity.ok().body("categories successfully saved");
    }
}
