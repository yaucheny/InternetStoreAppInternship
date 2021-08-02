package com.exposit.dto;

import com.exposit.model.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class ProductDto {

    private Long id;
    @NotEmpty
    @Size(min = 2, message ="name of product should be at least 2 characters" )
    private String name;
    @NotEmpty
    @Size(min = 2, message ="name of producer should be at least 2 characters" )
    private String producer;
    private List<CategoryEntity> categoryList;
}
