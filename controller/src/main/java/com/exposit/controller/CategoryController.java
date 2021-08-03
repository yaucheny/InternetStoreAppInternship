package com.exposit.controller;


import com.exposit.api.service.CategoryService;
import com.exposit.dto.CategoryDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j
@RestController
@RequestMapping("/category")
@Tag(name="Category", description="interaction with category")
public class CategoryController {

    private static final String REQUEST = "receive request: /category/";
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value ="Return category by id" )
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable Long id) {
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }

    @ApiOperation(value ="Return all categories" )
    @GetMapping(value = "/")
    public ResponseEntity<List<CategoryDto>> getAll() {
        log.info(REQUEST);
        return ResponseEntity.ok().body(categoryService.getAllCategory());
    }

    @ApiOperation(value ="Delete category by id" )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(String
                .format("category %s successfully deleted", id));
    }

    @ApiOperation(value ="Create new category" )
    @PostMapping(value = "/")
    public ResponseEntity<String> save(@Valid @RequestBody CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body("new category added");
    }

    @ApiOperation(value ="Update category by id" )
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,
                                         @Valid @RequestBody CategoryDto categoryDto) {
        categoryService.updateCategory(id, categoryDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body(String
                .format("category %s successfully updated", id));
    }
}
