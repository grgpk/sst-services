package com.sst.mapper;


import org.mapstruct.Mapper;

import com.sst.sst_dto.TerminalDto;
import com.sst.sst_models.Terminal;

@Mapper(componentModel = "spring", uses = {ProviderMapper.class})
public interface TerminalMapper {

	Terminal toTerminal(TerminalDto terminalDto);

	TerminalDto fromTerminal(Terminal terminal);

}
