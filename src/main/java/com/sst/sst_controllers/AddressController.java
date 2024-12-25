package com.sst.sst_controllers;

import com.sst.converter.AddressDtoConverter;
import com.sst.sst_dto.AddressResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sst.sst_dto.AddressRequestDto;
import com.sst.sst_models.Address;
import com.sst.sst_services.AddressService;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;


    private final AddressDtoConverter addressDtoConverter;


    public AddressController(AddressService addressService, AddressDtoConverter addressDtoConverter) {
        this.addressService = addressService;
        this.addressDtoConverter = addressDtoConverter;
    }

    @PostMapping
    public ResponseEntity<AddressResponseDto> createAddress(@RequestBody AddressRequestDto address) {
    	AddressResponseDto createdAddress = addressService.createAddress(addressDtoConverter.convertAddressDtoToAddress(address));
        return ResponseEntity.ok(createdAddress);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        return ResponseEntity.ok(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(id, address);
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
