package com.sst.sst_controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sst.sst_dto.ProviderGroupDto;
import com.sst.sst_services.ProviderGroupService;

@RestController
@RequestMapping("/provider-groups")
public class ProviderGroupController {

	private final ProviderGroupService providerGroupService;

	public ProviderGroupController(ProviderGroupService providerGroupService) {
		this.providerGroupService = providerGroupService;
	}

	@PostMapping
	public ProviderGroupDto createProviderGroup(@RequestBody ProviderGroupDto providerGroup) {
		return providerGroupService.saveProviderGroup(providerGroup);
	}

	@GetMapping
	public List<ProviderGroupDto> getAllProviderGroups() {
		return providerGroupService.getAllProviderGroups();
	}

	@GetMapping("/{id}")
	public ProviderGroupDto getProviderGroupById(@PathVariable Long id) {
		return providerGroupService.getProviderGroupById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteProvider(@PathVariable Long id) {
		providerGroupService.deleteProviderGroupById(id);
	}

}
