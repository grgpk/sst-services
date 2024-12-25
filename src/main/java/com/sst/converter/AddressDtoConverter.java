package com.sst.converter;

import com.sst.sst_dto.AddressRequestDto;
import com.sst.sst_dto.AddressResponseDto;
import com.sst.sst_models.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Address convertAddressDtoToAddress(AddressRequestDto addressDto) {
        return modelMapper.map(addressDto, Address.class);
    }

    public AddressResponseDto convertAddressToAddressDto(Address address) {
        return modelMapper.map(address, AddressResponseDto.class);
    }

}
