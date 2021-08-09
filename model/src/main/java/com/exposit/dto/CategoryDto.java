package com.exposit.dto;

import com.exposit.model.db.CategoryDb;
import io.swagger.annotations.ApiModelProperty;
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
    @Min(value = 1, message = "value of id should be more than 0")
    @ApiModelProperty(notes = "id of category")
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "name should be at least 2 characters")
    @ApiModelProperty(notes = "name of category")
    private String name;

    @ApiModelProperty(notes = "parent category")
    private Long parentId;

    @ApiModelProperty(notes = "childList of categories")
    private List<CategoryDb> childList;
}
