package com.sst.sst_repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sst.sst_models.Payment;
import com.sst.sst_models.PaymentStatus;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	// Find payments with the status "CREATED"
	List<Payment> findByStatus(PaymentStatus status);
}
