package com.exposit.api.service;

import com.exposit.domain.dto.ProductDto;

import java.util.List;

/**
 * Service interface for{@link com/exposit/domain/model/db/ProductDb.java}.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public interface ProductService {
    /**
     * Returns Product by id.
     *
     * @param productDto dto object of saving Product
     * @author Yauheni Markevich
     */
    void addProduct(ProductDto productDto);

    /**
     * Deletes Product.
     *
     * @param id Product with id to delete
     * @throws com.exposit.utils.exceptions.ServiceException if Product was not found
     * @author Yauheni Markevich
     */
    void deleteProduct(Long id);

    /**
     * Updates Product.
     *
     * @param id         Product with id to update
     * @param productDto dto object of searching Product
     * @throws com.exposit.utils.exceptions.ServiceException if Product was not found
     * @author Yauheni Markevich
     */
    void updateProduct(Long id, ProductDto productDto);

    /**
     * Returns Product by id.
     *
     * @param id of searching Product
     * @return ProductDto.
     * @throws com.exposit.utils.exceptions.ServiceException if Product was not found
     * @author Yauheni Markevich
     */
    ProductDto getProductById(Long id);

    /**
     * Gets List of Products.
     *
     * @return List<ProductDto> of Products or emptyList
     * @author Yauheni Markevich
     */
    List<ProductDto> getAllProducts();

    /**
     * Saves Products to file.
     *
     * @author Yauheni Markevich
     */
    void saveProductToFile();
}
