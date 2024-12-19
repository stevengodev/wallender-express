package com.foliaco.wallender_express.service;

import com.foliaco.wallender_express.dto.AddressDto;

import java.util.Optional;

public interface IAddressService {

    AddressDto getAddressById(Integer id);

    AddressDto createAddress(String country, String city, String neighborhood);

    Optional<AddressDto> updateAddress(Integer id, String country, String city, String neighborhood);

    void deleteAddressById(Integer id);

}
