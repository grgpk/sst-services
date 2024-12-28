package com.sst.sst_services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sst.mapper.TerminalMapper;
import com.sst.sst_dto.TerminalDto;
import com.sst.sst_models.Terminal;
import com.sst.sst_repositories.TerminalRepository;

import java.util.List;

@Service
public class TerminalService {

	private final TerminalRepository terminalRepository;
	private final TerminalMapper terminalMapper;

	public TerminalService(TerminalRepository terminalRepository, TerminalMapper terminalMapper) {
		this.terminalRepository = terminalRepository;
		this.terminalMapper = terminalMapper;
	}

	// Create or Update a Terminal
	public TerminalDto saveTerminal(TerminalDto terminal) {

		return terminalMapper.fromTerminal(terminalRepository.save(terminalMapper.toTerminal(terminal)));
	}

	// Retrieve All Terminals
	public List<Terminal> getAllTerminals() {
		return terminalRepository.findAll();
	}

	// Retrieve a Terminal by ID
	public Terminal getTerminalById(Long id) {
		return terminalRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Terminal not found with ID: " + id));
	}

	// Delete a Terminal by ID
	public void deleteTerminalById(Long id) {
		if (!terminalRepository.existsById(id)) {
			throw new RuntimeException("Terminal not found with ID: " + id);
		}
		terminalRepository.deleteById(id);
	}

}
