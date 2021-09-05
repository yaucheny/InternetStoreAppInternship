package com.exposit.api.service;

import com.exposit.domain.dto.CategoryDto;

import java.util.List;

/**
 * Service interface for{@link com/exposit/domain/model/db/CategoryDb.java}.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public interface CategoryService {

    void addCategory(CategoryDto categoryDto);

    void deleteCategory(Long id);

    void updateCategory(Long id, CategoryDto categoryDto);

    CategoryDto getCategoryById(Long id);

    List<CategoryDto> getAllCategory();

    void saveCategoryToFile();
}
