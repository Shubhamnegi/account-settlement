package com.settlement.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.settlement.demo.model.Domain;
import com.settlement.demo.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DomainQuery implements GraphQLQueryResolver {

    @Autowired
    DomainService domainService;

    public Domain getDomain(Long domainId) {
        return domainService.findDomainByDomainId(domainId);
    }

    public List<Domain> getDomains(Integer limit, Integer offset) {
        return domainService.findAllDomains();
    }
}
