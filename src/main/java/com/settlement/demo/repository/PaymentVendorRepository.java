package com.settlement.demo.repository;

import com.settlement.demo.model.PaymentVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentVendorRepository extends JpaRepository<PaymentVendor, Long> {
    PaymentVendor findPaymentVendorByName(String name);

    List<PaymentVendor> findPaymentVendorsByIsActive(Boolean active);
}
