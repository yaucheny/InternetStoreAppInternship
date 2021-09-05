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

     void addProduct(ProductDto productDto);

    void deleteProduct(Long id);

    void updateProduct(Long id, ProductDto productDto);

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

    void saveProductToFile();


}
