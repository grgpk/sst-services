package com.sst.sst_models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "sst_schema")
@Setter
@Getter
@RequiredArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String street;
	private String city;
}
