package com.sst.sst_dto;

import java.util.List;

import com.sst.sst_models.Provider;

public record ProviderGroupDto(Long id, String name, String description, List<Provider> providers) {
}
