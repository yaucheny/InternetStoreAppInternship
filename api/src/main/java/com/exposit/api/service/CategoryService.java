package com.exposit.api.service;

import com.exposit.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    void addCategory(CategoryDto categoryDto);

    void deleteCategory(Long id);

    void updateCategory(Long id, CategoryDto categoryDto);

    CategoryDto getCategoryById(Long id);

    List<CategoryDto> getAllCategory();

    void saveCategoryToFile();
}
