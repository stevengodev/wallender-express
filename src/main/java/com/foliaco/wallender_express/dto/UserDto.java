package com.foliaco.wallender_express.dto;

import java.time.LocalDate;

public record UserDto(String idCard,
                      String typeIdCard,
                      String names,
                      String lastnames,
                      String email,
                      String password,
                      String phone,
                      LocalDate createdAt,
                      String photo,
                      int addressId) {
}
