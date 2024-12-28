package com.sst.sst_models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "sst_schema")
@Data
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "terminal_id", referencedColumnName = "id")
	private Terminal terminal;

	@OneToOne
	@JoinColumn(name = "provider_id", referencedColumnName = "id")
	private Provider provider;

	private String abonentCode;

	private BigDecimal amount;

	private PaymentStatus status;

	private LocalDateTime createTime;
}
