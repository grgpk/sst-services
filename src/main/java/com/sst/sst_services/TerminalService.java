package com.sst.sst_services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sst.sst_dto.TerminalDto;
import com.sst.sst_models.Terminal;
import com.sst.sst_repositories.TerminalRepository;

import java.util.List;

@Service
public class TerminalService {

	private final TerminalRepository terminalRepository;
	private final ModelMapper modelMapper;

	public TerminalService(TerminalRepository terminalRepository, ModelMapper modelMapper) {
		this.terminalRepository = terminalRepository;
		this.modelMapper = modelMapper;
	}

	// Create or Update a Terminal
	public Terminal saveTerminal(TerminalDto terminal) {
		return terminalRepository.save(modelMapper.map(terminal, Terminal.class));
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
