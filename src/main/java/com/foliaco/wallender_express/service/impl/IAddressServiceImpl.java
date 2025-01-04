package com.foliaco.wallender_express.service.impl;

import com.foliaco.wallender_express.dto.AddressDto;
import com.foliaco.wallender_express.entity.AddressEntity;
import com.foliaco.wallender_express.exception.NotFoundException;
import com.foliaco.wallender_express.repository.IAddressRepository;
import com.foliaco.wallender_express.service.IAddressService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
public class IAddressServiceImpl implements IAddressService {

    private ModelMapper modelMapper;

    private IAddressRepository addressRepository;

    @Transactional(readOnly = false)
    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        AddressEntity addressEntity = modelMapper.map(addressDto, AddressEntity.class);
        AddressEntity savedAddress = addressRepository.save(addressEntity);
        return modelMapper.map(savedAddress, AddressDto.class);
    }

    @Transactional(readOnly = false)
    @Override
    public AddressDto updateAddress(Integer id, AddressDto addressDto) {

        AddressEntity addressEntity = addressRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Address not found")
        );

        addressEntity.setCity(addressDto.city());
        addressEntity.setNeighborhood(addressDto.neighborhood());
        addressEntity.setCountry(addressDto.country());

        addressRepository.save(addressEntity);

        return modelMapper.map(addressEntity, AddressDto.class);

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<AddressDto> getAddressById(Integer id) {
        Optional<AddressEntity> addressEntity = addressRepository.findById(id);

        if (addressEntity.isEmpty()) {
            throw new NotFoundException("Address not found");
        }

        return addressEntity.map(address -> modelMapper.map(address, AddressDto.class));
    }

    @Transactional(readOnly = false)
    @Override
    public boolean deleteAddressById(Integer id) {
        Optional<AddressDto> addressDto = addressRepository.findById(id).map(
                addressEntity  -> modelMapper.map(addressEntity, AddressDto.class)
        );

        if (addressDto.isPresent()) {
            addressRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
