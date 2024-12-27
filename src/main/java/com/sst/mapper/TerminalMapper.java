package com.sst.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.sst.sst_dto.TerminalDto;
import com.sst.sst_models.Terminal;

@Component
@Mapper(uses = {ProviderMapper.class})
public interface TerminalMapper {
	
	Terminal map(TerminalDto terminalDto);
	
	TerminalDto map(Terminal terminal);
	
	List<TerminalDto> map(List<Terminal> terminals);

}
