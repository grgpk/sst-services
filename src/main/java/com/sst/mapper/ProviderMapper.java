package com.sst.mapper;

import org.mapstruct.Mapper;

import com.sst.sst_dto.ProviderDto;
import com.sst.sst_models.Provider;

@Mapper(componentModel = "spring")
public interface ProviderMapper {

	ProviderDto fromProvider(Provider provider);
	
	Provider toProvider(ProviderDto providerDto);
}
