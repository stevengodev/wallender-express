package com.foliaco.wallender_express.service;

import com.foliaco.wallender_express.dto.UserDto;

import java.util.Optional;

public interface IUserService {

    Optional<UserDto> getUserByEmail(String email);

    Optional<UserDto> getUserByCardId(String cardId);

    UserDto createUser(UserDto userDto);

    Optional<UserDto> updateUser(String cardId, UserDto userDto);

    void deleteUserByIdCard(String idCard);

}
