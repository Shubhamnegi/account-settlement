package com.settlement.demo.service;

import com.settlement.demo.model.PaymentVendor;
import com.settlement.demo.repository.PaymentVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaymentVendorService {

    @Autowired
    private PaymentVendorRepository paymentVendorRepository;

    public PaymentVendor savePaymentVendor(PaymentVendor pv) {
        return paymentVendorRepository.save(pv);
    }

    public PaymentVendor getPaymentVendorById(Long id) {
        return paymentVendorRepository.getOne(id);
    }

    public PaymentVendor getPaymentVendorByName(String name) {
        return paymentVendorRepository.findPaymentVendorByName(name);
    }

    public List<PaymentVendor> getAllActivePaymentVendors() {
        return paymentVendorRepository.findPaymentVendorsByIsActive(true);
    }


}
