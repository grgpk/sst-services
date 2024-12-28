package com.sst.sst_models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "sst_schema")
@Data
public class Terminal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;


	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "terminal_id", referencedColumnName = "id")
	private List<Provider> availableProviders;

	private LocalDateTime lastAccessTime;

	private boolean active;
}
