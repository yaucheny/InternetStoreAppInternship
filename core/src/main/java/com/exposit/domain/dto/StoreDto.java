package com.exposit.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Schema(description = "entity of store")
public class StoreDto {

    @Min(value = 1, message = "value of id should be more than 0")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "firstname should be at least 2 characters")
    @ApiModelProperty(notes = "name of store")
    private String name;

    @NotEmpty
    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",
            message = "internet page should be a valid page format")
    @ApiModelProperty(notes = "internet page of store")
    private String internetPage;

    @NotEmpty
    @ApiModelProperty(notes = "phone number of store")
    private String phoneNumber;
}
