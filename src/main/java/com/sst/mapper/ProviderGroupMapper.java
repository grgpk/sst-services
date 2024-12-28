package com.sst.mapper;

import org.mapstruct.Mapper;

import com.sst.sst_dto.ProviderDto;
import com.sst.sst_dto.ProviderGroupDto;
import com.sst.sst_models.Provider;
import com.sst.sst_models.ProviderGroup;

@Mapper(componentModel = "spring")
public interface ProviderGroupMapper {

	ProviderGroupDto fromProviderGroup(ProviderGroup providerGroup);
	
	ProviderGroup toProviderGroup(ProviderGroupDto providerGroupDto);
}
