package com.exposit.controller;


import com.exposit.api.service.CategoryService;
import com.exposit.dto.CategoryDto;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j
@RestController
@RequestMapping("/category")

public class CategoryController {

    private static final String REQUEST = "receive request: /category/";
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable Long id) {
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<CategoryDto>> getAll() {
        log.info(REQUEST);
        return ResponseEntity.ok().body(categoryService.getAllCategory());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(String.format("category %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(@RequestBody CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body("new category added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        categoryService.updateCategory(id, categoryDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body(String.format("category %s successfully updated", id));
    }
}
