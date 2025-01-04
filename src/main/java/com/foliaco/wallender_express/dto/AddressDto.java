package com.foliaco.wallender_express.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressDto(@NotBlank String country,
                         @NotBlank String city,
                         @NotBlank String neighborhood) {
}
