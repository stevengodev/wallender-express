package com.foliaco.wallender_express.controller;

import com.foliaco.wallender_express.dto.AddressDto;
import com.foliaco.wallender_express.service.IAddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
@AllArgsConstructor
public class AddressController {

    private final IAddressService addressService;

    @PostMapping("/")
    public ResponseEntity<AddressDto> saveAddress(@Valid @RequestBody AddressDto address){
        AddressDto addressDto = addressService.createAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable Integer id){
        return addressService.getAddressById(id).map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable Integer id,
                                                    @Valid @RequestBody AddressDto address){
        AddressDto addressDto = addressService.updateAddress(id, address);
        return ResponseEntity.ok(addressDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAddress(@PathVariable Integer id){
        boolean isDeleted = addressService.deleteAddressById(id);
        return ResponseEntity.ok(isDeleted);
    }

}
