package com.sst.sst_dto;

import java.math.BigDecimal;

public record ProviderDto(Long id, String name, String deptCode, String payCode, Integer maxThreads,
		BigDecimal minAmount, BigDecimal maxAmount, boolean active) {
}
