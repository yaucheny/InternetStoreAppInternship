package com.exposit.api.service;

import com.exposit.model.*;
import com.exposit.model.CategoryEntity;

import java.util.List;

public interface ProductService {

    ProductEntity addProduct(String name, String producer,
                             List<CategoryEntity> categoryList);

    void deleteProduct(Long id);

    void updateProduct(Long id, String name, String producer,
                       List<CategoryEntity> categoryList);

    ProductEntity getProductById(Long id);

    List<ProductEntity> getAllProducts();

    void saveProductToFile();


}
