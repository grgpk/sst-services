package com.sst.sst_controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sst.sst_dto.ProviderDto;
import com.sst.sst_services.ProviderService;

@RestController
@RequestMapping("/providers")
public class ProviderController {

	private final ProviderService providerService;

	public ProviderController(ProviderService providerService) {
		this.providerService = providerService;
	}

	@PostMapping
	public ProviderDto createProvider(@RequestBody ProviderDto provider) {
		return providerService.saveProvider(provider);
	}

	@GetMapping
	public List<ProviderDto> getAllProviders() {
		return providerService.getAllProviders();
	}

	@GetMapping("/{id}")
	public ProviderDto getProviderById(@PathVariable Long id) {
		return providerService.getProviderById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteProvider(@PathVariable Long id) {
		providerService.deleteProviderById(id);
	}

}
