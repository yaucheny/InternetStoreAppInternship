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
    @Pattern(regexp = "(http(s)?://)?([\\w-]+\\.)+[\\w-]+(/[\\w- ;,./?%&=]*)?",
            message = "internet page should be a valid page format")
    private String internetPage;
    @NotEmpty
    @Pattern(regexp = "\\(^(\\\\+\\\\d{1,3}( )?)?((\\\\(\\\\d{3}\\\\))|\\\\d{3})[- .]?\\\\d{3}[- .]?\\\\d{4}$\" \n"
            + " + \"|^(\\\\+\\\\d{1,3}( )?)?(\\\\d{3}[ ]?){2}\\\\d{3}$\" \n"
            + " + \"|^(\\\\+\\\\d{1,3}( )?)?(\\\\d{3}[ ]?)(\\\\d{2}[ ]?){2}\\\\d{2}$",
            message = "phone number should be a valid phone format")
    private String phoneNumber;
}
