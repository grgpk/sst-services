package com.sst.sst_services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sst.mapper.ProviderMapper;
import com.sst.sst_dto.ProviderDto;
import com.sst.sst_exceptions.HttpRequestException;
import com.sst.sst_repositories.ProviderRepository;

@Service
public class ProviderService {

	private final ProviderRepository providerRepository;
	private final ProviderMapper providerMapper;

	public ProviderService(ProviderRepository providerRepository, ProviderMapper providerMapper) {
		this.providerRepository = providerRepository;
		this.providerMapper = providerMapper;
	}

	public ProviderDto saveProvider(ProviderDto provider) {

		return providerMapper.fromProvider(providerRepository.save(providerMapper.toProvider(provider)));
	}

	public List<ProviderDto> getAllProviders() {
		return providerRepository.findAll().stream().map(provider -> providerMapper.fromProvider(provider)).toList();
	}

	public ProviderDto getProviderById(Long id) {
		var provider = providerRepository.findById(id)
				.orElseThrow(() -> new HttpRequestException("Provider not found with ID: " + id));
	
		return providerMapper.fromProvider(provider);
	}

	public void deleteProviderById(Long id) {
		if (!providerRepository.existsById(id)) {
			throw new HttpRequestException("Provider not found with ID: " + id);
		}
		providerRepository.deleteById(id);
	}

}
