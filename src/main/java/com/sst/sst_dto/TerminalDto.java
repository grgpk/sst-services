package com.sst.sst_dto;

import java.time.LocalDateTime;
import java.util.List;

public record TerminalDto(int id, AddressDto address, boolean active, LocalDateTime lastAccessTime,
		List<ProviderDto> availableProviders) {

}
