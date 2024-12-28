package com.sst.sst_models;

public enum PaymentStatus {

	CREATED("Created"), PENDING("Pending"), PERFORMED("Performed"), REJECTED("Rejected");

	private final String status;

	PaymentStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
