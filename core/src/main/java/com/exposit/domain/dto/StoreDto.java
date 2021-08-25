package com.exposit.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class StoreDto {

    private Long id;
    @NotEmpty
    @Size(min = 2, message = "firstname should be at least 2 characters")
    private String name;

    @NotEmpty
    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",
            message = "internet page should be a valid page format")
    private String internetPage;

    @NotEmpty
    private String phoneNumber;
}
