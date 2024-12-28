package com.sst.jobs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sst.sst_models.Payment;
import com.sst.sst_models.PaymentStatus;
import com.sst.sst_services.PaymentService;

@Component
public class PaymentJob {

    @Autowired
    private PaymentService paymentService;

    @Scheduled(fixedRate = 60000) // Runs every minute
    public void processNewPayments() {
        System.out.println("Checking for new payments...");
        List<Payment> newPayments = paymentService.getNewPayments();

        for (Payment payment : newPayments) {
            paymentService.updatePaymentStatus(payment.getId(), PaymentStatus.PENDING);

            boolean isSuccess = paymentService.processPayment(payment);
            if (isSuccess) {
                paymentService.updatePaymentStatus(payment.getId(), PaymentStatus.PERFORMED);
                System.out.println("Payment ID " + payment.getId() + " processed successfully.");
            } else {
                paymentService.updatePaymentStatus(payment.getId(), PaymentStatus.REJECTED);
                System.out.println("Payment ID " + payment.getId() + " processing failed.");
            }
        }
    }
}

