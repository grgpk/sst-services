package com.sst.sst_services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sst.mapper.TerminalMapper;
import com.sst.sst_dto.TerminalDto;
import com.sst.sst_exceptions.HttpRequestException;
import com.sst.sst_repositories.TerminalRepository;

@Service
public class TerminalService {

	private final TerminalRepository terminalRepository;
	private final TerminalMapper terminalMapper;

	public TerminalService(TerminalRepository terminalRepository, TerminalMapper terminalMapper) {
		this.terminalRepository = terminalRepository;
		this.terminalMapper = terminalMapper;
	}

	public TerminalDto saveTerminal(TerminalDto terminal) {

		return terminalMapper.fromTerminal(terminalRepository.save(terminalMapper.toTerminal(terminal)));
	}

	public List<TerminalDto> getAllTerminals() {
		return terminalRepository.findAll().stream().map(terminal -> terminalMapper.fromTerminal(terminal)).toList();
	}

	public TerminalDto getTerminalById(Long id) {
		var terminal = terminalRepository.findById(id)
				.orElseThrow(() -> new HttpRequestException("Terminal not found with ID: " + id));
	
		return terminalMapper.fromTerminal(terminal);
	}

	public void deleteTerminalById(Long id) {
		if (!terminalRepository.existsById(id)) {
			throw new HttpRequestException("Terminal not found with ID: " + id);
		}
		terminalRepository.deleteById(id);
	}

}
