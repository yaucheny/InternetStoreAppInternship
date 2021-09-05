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

@Getter
@Setter
@ToString
@Schema(description = "entity of product")
public class ProductDto {

    @Min(value = 1, message = "value of id should be more than 0")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "name of product should be at least 2 characters")
    @ApiModelProperty(notes = "name of product")
    private String name;

    @NotEmpty
    @Size(min = 2, message = "name of producer should be at least 2 characters")
    @ApiModelProperty(notes = "producer of product")
    private String producer;

    @ApiModelProperty(notes = "categories of product")
    private List<CategoryDb> categoryList;
}
