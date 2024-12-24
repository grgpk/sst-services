package com.sst.sst_services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sst.sst_models.Address;
import com.sst.sst_repositories.AddressRepository;

import java.util.List;

@Service
public class AddressService {

	private final AddressRepository addressRepository;
	private final ModelMapper modelMapper;

	public AddressService(AddressRepository addressRepository, ModelMapper modelMapper) {
		this.addressRepository = addressRepository;
		this.modelMapper = modelMapper;
	}

	// Create Address
	public Address createAddress(Address address) {
		return addressRepository.save(address);
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
