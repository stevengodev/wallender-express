package com.foliaco.wallender_express.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotBlank
    private String neighborhood;

}
