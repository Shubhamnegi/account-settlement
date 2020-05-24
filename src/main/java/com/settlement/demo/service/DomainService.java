package com.settlement.demo.service;

import com.settlement.demo.model.Domain;
import com.settlement.demo.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@Service
public class DomainService {


    @Autowired
    DomainRepository domainRepository;


    public List<Domain> findAllDomains() {
        return domainRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Domain findDomainByDomainId(Long domainId) {
        return domainRepository.findById(domainId).orElse(null);
    }

    @Transactional
    public Domain saveDomain(Domain domain) {
        return domainRepository.save(domain);
    }

}
