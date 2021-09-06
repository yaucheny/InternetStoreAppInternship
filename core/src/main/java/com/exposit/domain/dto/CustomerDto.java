package com.exposit.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
/**
 * Dto object that represents a Customer.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Schema(description = "entity of customer")
public class CustomerDto {

    @Min(value = 1, message = "value of id should be more than 0")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "first name should be at least 2 characters")
    @ApiModelProperty(notes = "first name of customer")
    private String firstName;

    @NotEmpty
    @Size(min = 2, message = "last name should be at least 2 characters")
    @ApiModelProperty(notes = "last name of customer")
    private String lastName;

    @NotEmpty
    @Size(min = 2, message = "address should be at least 2 characters")
    @ApiModelProperty(notes = "address of customer")
    private String address;

    @Email(message = "email should be a valid email format")
    @NotEmpty
    @ApiModelProperty(notes = "email of customer")
    private String email;
}
