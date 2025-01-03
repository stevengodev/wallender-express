package com.foliaco.wallender_express.service;

import com.foliaco.wallender_express.dto.UserDto;

import java.util.Optional;

public interface IUserService {

    /**
     * Crea un nuevo usuario
     *
     * @param userDto
     * @return Usuario
     */
    UserDto createUser(UserDto userDto);

    /**
     * Actualiza un usuario
     * @param idCard
     * @param userDto
     * @return Usuario
     */
    Optional<UserDto> updateUser(String idCard, UserDto userDto);

    /**
     * Obtiene un usuario por email
     * @param email
     * @return Usuario
     */
    Optional<UserDto> getUserByEmail(String email);

    /**
     * Obtiene un usuario por número de cédula
     * @param idCard
     * @return Usuario
     */
    Optional<UserDto> getUserByIdCard(String idCard);

    /**
     * Elimina un usuario por número de cédula
     * @param idCard
     */
    void deleteUserByIdCard(String idCard);

}
