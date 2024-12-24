package com.sst.sst_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sst.sst_models.Terminal;
import com.sst.sst_services.TerminalService;

import java.util.List;

@RestController
@RequestMapping("/terminals")
public class TerminalController {

	private final TerminalService terminalService;

	@Autowired
	public TerminalController(TerminalService terminalService) {
		this.terminalService = terminalService;
	}

	@PostMapping
	public Terminal createTerminal(@RequestBody Terminal terminal) {
		return terminalService.saveTerminal(terminal);
	}

	@GetMapping
	public List<Terminal> getAllTerminals() {
		return terminalService.getAllTerminals();
	}

	@GetMapping("/{id}")
	public Terminal getTerminalById(@PathVariable Long id) {
		return terminalService.getTerminalById(id);
	}

	
	@DeleteMapping("/{id}")
	public void deleteTerminal(@PathVariable Long id) {
		terminalService.deleteTerminalById(id);
	}

}
