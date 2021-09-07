package com.exposit.domain.dto;

import com.exposit.domain.model.db.CategoryDb;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Dto object that represents a Category.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Schema(description = "Entity category")
public class CategoryDto {

        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "name should be at least 2 characters")
    @ApiModelProperty(notes = "name of category")
    private String name;

    @Min(value = 0, message = "quantity should be more than 0")
    @ApiModelProperty(notes = "parent of category")
    private Long parentId;

    @ApiModelProperty(notes = "childList of categories")
    private List<CategoryDb> childList;
}
