package com.sst.sst_models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "sst_schema")
@Setter
@Getter
@RequiredArgsConstructor
public class Terminal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	private boolean active;

	private LocalDateTime lastAccessTime;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "terminal_id")
	private List<Provider> availableProviders;

}
