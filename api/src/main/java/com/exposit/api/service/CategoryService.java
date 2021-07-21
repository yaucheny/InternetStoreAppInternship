package com.exposit.api.service;

import com.exposit.model.CategoryEntity;


import java.util.List;

public interface CategoryService {

    CategoryEntity addCategory(String name, Long parentId);

    void deleteCategory(Long id);

    void updateCategory(Long id, String name,
                        Long parentId);

    CategoryEntity getCategoryById(Long id);

    List<CategoryEntity> getAllCategory();

    void saveCategoryToFile();
}
