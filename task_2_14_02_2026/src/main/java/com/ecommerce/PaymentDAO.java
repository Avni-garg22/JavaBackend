package com.ecommerce;

public interface PaymentDAO {
    void savePayment(Payment p);
    Payment findPayment(Long id);
}