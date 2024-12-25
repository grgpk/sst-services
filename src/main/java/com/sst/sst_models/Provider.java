package com.sst.sst_models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "sst_schema")
@Data
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
