package com.settlement.demo;


import com.settlement.demo.model.Admin;
import com.settlement.demo.service.AdminService;
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
public class AdminTests {

    @Autowired
    private AdminService adminService;

    @TestConfiguration
    static class AdminServiceImplTestContextConfiguration {

        @Bean
        public AdminService adminService() {
            return new AdminService();
        }
    }

    @Test
    @Order(1)
    void saveAdmin() {
        Admin a = new Admin();
        a.setEmail("shubham16negi@gmail.com");
        a.setPassword("qwerty");
        a.setMobile("+919560254331");
        a.setActive(true);

        Admin newA = this.adminService.saveAdmin(a);
        assert newA.getId() != null;
    }

    @Test
    @Order(2)
    void getAllAdmin() {
        List<Admin> allAdmins = this.adminService.findAllAdmin();
        assert allAdmins.size() > 0;
    }

    @Test
    @Order(3)
    void getAdminByEmail() {
        Admin a = this.adminService.findAdminByEmail("shubham16negi@gmail.com");
        assert a.getId() != null;
        assert a.getEmail().equals("shubham16negi@gmail.com");
        assert a.getDomains().size() > 0;
    }

}
