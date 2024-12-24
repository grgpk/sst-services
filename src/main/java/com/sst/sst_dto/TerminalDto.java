package com.sst.sst_dto;

import java.time.LocalDateTime;
import java.util.List;

import com.sst.sst_models.Address;
import com.sst.sst_models.Provider;

public record TerminalDto(Address address, boolean active, LocalDateTime lastAccessTime,
		List<Provider> availableProviders) {

}
