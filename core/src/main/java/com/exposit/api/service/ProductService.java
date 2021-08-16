package com.exposit.api.service;

import com.exposit.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {

     void addProduct(ProductDto productDto);

    void deleteProduct(Long id);

    void updateProduct(Long id, ProductDto productDto);

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

    void saveProductToFile();


}
