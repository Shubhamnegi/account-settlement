package com.settlement.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.settlement.demo.model.Admin;
import com.settlement.demo.model.Domain;
import com.settlement.demo.service.AdminService;
import com.settlement.demo.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DomainMutation implements GraphQLMutationResolver {

    @Autowired
    DomainService domainService;

    @Autowired
    AdminService adminService;

    public Domain createDomain(String name, Long adminId, Boolean isActive) {
        Admin a = this.adminService.findAdminByAdminId(adminId);

        Domain d = new Domain();
        d.setAdmin(a);
        d.setActive(isActive);
        d.setName(name);

        return this.domainService.saveDomain(d);
    }
}
