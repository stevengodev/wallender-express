package com.foliaco.wallender_express.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserDto(@NotBlank String idCard,
                      @NotBlank String typeIdCard,
                      @NotBlank String names,
                      @NotBlank String lastnames,
                      @NotBlank String email,
                      @NotBlank String password,
                      @NotBlank String phone,
                      @NotNull LocalDate createdAt,
                      @NotBlank String photo,
                      int addressId) {
}
