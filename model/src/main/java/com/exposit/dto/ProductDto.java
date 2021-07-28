package com.exposit.dto;

import com.exposit.model.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private String producer;
    private List<CategoryEntity> categoryList;
}
