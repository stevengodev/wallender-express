package com.foliaco.wallender_express.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserDto {

    @NotBlank
    private String idCard;
    @NotBlank
    private String typeIdCard;
    @NotBlank
    private String names;
    @NotBlank
    private String lastnames;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String phone;
    @NotNull
    private LocalDate createdAt;
    @NotBlank
    private String photo;
    private int addressId;

}
