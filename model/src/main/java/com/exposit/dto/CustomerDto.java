package com.exposit.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CustomerDto {

    private Long id;
    @NotEmpty
    @Size(min = 2, message = "firstname should be at least 2 characters")
    private String firstName;
    @NotEmpty
    @Size(min = 2, message = "lastname should be at least 2 characters")
    private String lastName;
    @NotEmpty
    @Size(min = 2, message = "address should be at least 2 characters")
    private String address;
    @Email(message = "email should be a valid email format")
    @NotEmpty
    private String email;
}
