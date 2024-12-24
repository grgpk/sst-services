package com.sst.sst_models;

import java.math.BigDecimal;

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
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String deptCode;
	private String payCode;
	private Integer maxThreads;
	private BigDecimal minAmount;
	private BigDecimal maxAmount;
	private boolean active;
}
