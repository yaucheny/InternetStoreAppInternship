package com.exposit.dto;

import com.exposit.model.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String name;
    private Long parentId;
    private List<CategoryEntity> childList;
}
