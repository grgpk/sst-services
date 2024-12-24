package com.sst.sst_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sst.sst_models.Terminal;
import com.sst.sst_repositories.TerminalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalService {

	private final TerminalRepository terminalRepository;

	@Autowired
	public TerminalService(TerminalRepository terminalRepository) {
		this.terminalRepository = terminalRepository;
	}

	// Create or Update a Terminal
	public Terminal saveTerminal(Terminal terminal) {
		return terminalRepository.save(terminal);
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
