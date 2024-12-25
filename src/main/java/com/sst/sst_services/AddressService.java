package com.sst.sst_services;

import com.sst.converter.AddressDtoConverter;
import com.sst.sst_dto.AddressResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sst.sst_models.Address;
import com.sst.sst_repositories.AddressRepository;

import java.util.List;

@Service
public class AddressService {

	private final AddressRepository addressRepository;
	private final AddressDtoConverter addressDtoConverter;

	public AddressService(AddressRepository addressRepository, AddressDtoConverter addressDtoConverter) {
		this.addressRepository = addressRepository;
        this.addressDtoConverter = addressDtoConverter;
    }

	// Create Address
	public AddressResponseDto createAddress(Address address) {
		Address newAddress = addressRepository.save(address);
		return addressDtoConverter.convertAddressToAddressDto(newAddress);
	}

	// Get All Addresses
	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

	// Get Address by ID
	public Address getAddressById(Long id) {
		return addressRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
	}

	// Update Address
	public Address updateAddress(Long id, Address updatedAddress) {
		Address existingAddress = addressRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Address not found with id: " + id));

		return addressRepository.save(existingAddress);
	}

	// Delete Address
	public void deleteAddress(Long id) {
		if (!addressRepository.existsById(id)) {
			throw new RuntimeException("Address not found with id: " + id);
		}
		addressRepository.deleteById(id);
	}
}
