package com.exposit.dto;

import com.exposit.model.CategoryEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Schema(description = "Entity category")
public class CategoryDto {

    private Long id;
    @NotEmpty
    @Size(min = 2, message ="name should be at least 2 characters" )
    private String name;
    @Min(value = 1, message = "value of id should be more than 0")
    private Long parentId;
    private List<CategoryEntity> childList;
}
