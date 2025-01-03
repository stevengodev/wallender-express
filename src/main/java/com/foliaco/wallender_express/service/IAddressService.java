package com.foliaco.wallender_express.service;

import com.foliaco.wallender_express.dto.AddressDto;

import java.util.Optional;

public interface IAddressService {

    /**
     * Crea una nueva direccion
     *
     * @param addressDto
     * @return Direccion
     */
    AddressDto createAddress(AddressDto addressDto);

    /**
     * Actualiza una direccion existente
     *
     * @param id
     * @param addressDto
     */
    Optional<AddressDto> updateAddress(Integer id, AddressDto addressDto);

    /**
     * Obtiene una direccion por id
     *
     * @param id
     * @return Direccion
     */
    AddressDto getAddressById(Integer id);

    /**
     * Elimina una direccion por id
     *
     * @param id
     */
    void deleteAddressById(Integer id);

}
