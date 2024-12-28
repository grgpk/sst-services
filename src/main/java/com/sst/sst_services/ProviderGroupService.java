package com.sst.sst_services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sst.mapper.ProviderGroupMapper;
import com.sst.sst_dto.ProviderDto;
import com.sst.sst_dto.ProviderGroupDto;
import com.sst.sst_exceptions.HttpRequestException;
import com.sst.sst_models.ProviderGroup;
import com.sst.sst_repositories.ProviderGroupRepository;

@Service
public class ProviderGroupService {

	private final ProviderGroupRepository providerGroupRepository;
	private final ProviderGroupMapper providerGroupMapper;

	public ProviderGroupService(ProviderGroupRepository providerGroupRepository,
			ProviderGroupMapper providerGroupMapper) {
		this.providerGroupRepository = providerGroupRepository;
		this.providerGroupMapper = providerGroupMapper;
	}

	public ProviderGroupDto saveProviderGroup(ProviderGroupDto providerGroup) {

		return providerGroupMapper
				.fromProviderGroup(providerGroupRepository.save(providerGroupMapper.toProviderGroup(providerGroup)));
	}

	public List<ProviderGroupDto> getAllProviderGroups() {
		return providerGroupRepository.findAll().stream()
				.map(providerGroup -> providerGroupMapper.fromProviderGroup(providerGroup)).toList();
	}

	public ProviderGroupDto getProviderGroupById(Long id) {
		var providerGroup = providerGroupRepository.findById(id)
				.orElseThrow(() -> new HttpRequestException("Provider group not found with ID: " + id));

		return providerGroupMapper.fromProviderGroup(providerGroup);
	}

	public void deleteProviderGroupById(Long id) {
		if (!providerGroupRepository.existsById(id)) {
			throw new HttpRequestException("Provider group not found with ID: " + id);
		}
		providerGroupRepository.deleteById(id);
	}

}
