package com.settlement.demo.repository;

import com.settlement.demo.model.DomainPaymentVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DomainPaymentVendorRepository extends JpaRepository<DomainPaymentVendor, Long> {
    List<DomainPaymentVendor> findByDomain_Id(Long domainId);

    DomainPaymentVendor findByDomain_IdAndPaymentVendor_Id(Long domainId, Long paymentVendorId);
}
