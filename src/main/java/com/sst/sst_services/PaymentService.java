package com.sst.sst_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sst.sst_exceptions.HttpRequestException;
import com.sst.sst_models.Payment;
import com.sst.sst_models.PaymentStatus;
import com.sst.sst_repositories.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public List<Payment> getNewPayments() {
		return paymentRepository.findByStatus(PaymentStatus.CREATED);
	}

	public void updatePaymentStatus(Long paymentId, PaymentStatus status) {
		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new HttpRequestException("Payment not found"));
		payment.setStatus(status);
		paymentRepository.save(payment);
	}

	public boolean processPayment(Payment payment) {
		try {
			// Simulate payment processing logic
			System.out.println("Processing payment with ID: " + payment.getId());
			Thread.sleep(1000); // Simulate processing delay
			return true; // Simulate successful processing
		} catch (Exception e) {
			return false; // Simulate failed processing
		}
	}
}
