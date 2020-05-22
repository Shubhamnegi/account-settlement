package com.settlement.demo;

import com.settlement.demo.model.Admin;
import com.settlement.demo.model.Domain;
import com.settlement.demo.service.AdminService;
import com.settlement.demo.service.DomainService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DomainTests {

    @Autowired
    private DomainService domainService;

    @Autowired
    private AdminService adminService;


    @TestConfiguration
    static class DomainServiceImplTestContextConfiguration {
        @Bean
        public DomainService employeeService() {
            return new DomainService();
        }
    }

    @TestConfiguration
    static class AdminServiceImplTestContextConfiguration {
        @Bean
        public AdminService adminService() {
            return new AdminService();
        }
    }


    @Test
    @Order(1)
    void saveDomain() {
        Admin a = this.adminService.findAdminByEmail("shubham16negi@gmail.com");

        Domain d = new Domain();
        d.setName("dbs");
        d.setActive(true);
        d.setAdmin(a);

        Domain n = this.domainService.saveDomain(d);
        assert n.getId() != null;
    }

    @Test
    @Order(2)
    void getAllDomains() {
        List<Domain> domains = domainService.findAllDomains();
        assert domains.size() > 0;
        assert domains.get(0).getAdmin().getEmail().equals("shubham16negi@gmail.com");
    }
}
