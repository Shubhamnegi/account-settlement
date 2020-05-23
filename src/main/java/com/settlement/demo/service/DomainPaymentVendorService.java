package com.settlement.demo.service;

import com.settlement.demo.model.DomainPaymentVendor;
import com.settlement.demo.repository.DomainPaymentVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainPaymentVendorService {

    @Autowired
    DomainPaymentVendorRepository domainPaymentVendorRepository;

    DomainPaymentVendor save(DomainPaymentVendor dpv) {
        return domainPaymentVendorRepository.save(dpv);
    }

    DomainPaymentVendor findByDomainAndPaymentVendor(Long domainId, Long paymentVendorId) {
        return domainPaymentVendorRepository.findByDomain_IdAndPaymentVendor_Id(domainId, paymentVendorId);
    }

    List<DomainPaymentVendor> findByDomainId(Long domainId) {
        return domainPaymentVendorRepository.findByDomain_Id(domainId);
    }

}
