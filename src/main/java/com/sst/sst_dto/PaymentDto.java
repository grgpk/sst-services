package com.sst.sst_dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sst.sst_models.PaymentStatus;

public record PaymentDto(Long id, TerminalDto terminal, ProviderDto provider, String abonentCode, BigDecimal amount,
		PaymentStatus status, LocalDateTime createTime) {
}
