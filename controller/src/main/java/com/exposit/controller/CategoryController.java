package com.exposit.controller;


import com.exposit.api.service.CategoryService;
import com.exposit.dto.CategoryDto;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j
//@RestController
@RequestMapping("/category")

public class CategoryController {

    private final CategoryService categoryService;
@Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable Long id) {
        log.info("receive request: /guest " + id);
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
}
