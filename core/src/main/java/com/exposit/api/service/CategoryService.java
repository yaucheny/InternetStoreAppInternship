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
    /**
     * Returns Category by id.
     *
     * @param categoryDto dto object of saving Category
     * @author Yauheni Markevich
     */
    void addCategory(CategoryDto categoryDto);

    /**
     * Deletes Category.
     *
     * @param id Category with id to delete
     * @throws com.exposit.utils.exceptions.ServiceException if Category was not found
     * @author Yauheni Markevich
     */
    void deleteCategory(Long id);

    /**
     * Updates Category.
     *
     * @param id          Category with id to update
     * @param categoryDto dto object of searching Category
     * @throws com.exposit.utils.exceptions.ServiceException if Category was not found
     * @author Yauheni Markevich
     */
    void updateCategory(Long id, CategoryDto categoryDto);

    /**
     * Returns Category by id.
     *
     * @param id of searching Category
     * @return CategoryDto.
     * @throws com.exposit.utils.exceptions.ServiceException if Category was not found
     * @author Yauheni Markevich
     */
    CategoryDto getCategoryById(Long id);

    /**
     * Gets List of Categories.
     *
     * @return List<CategoryDto> of Categories or emptyList
     * @author Yauheni Markevich
     */
    List<CategoryDto> getAllCategory();

    /**
     * Saves Categories to file.
     *
     * @author Yauheni Markevich
     */
    void saveCategoryToFile();
}
