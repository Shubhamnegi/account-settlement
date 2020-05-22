package com.settlement.demo;

import com.settlement.demo.model.Domain;
import com.settlement.demo.model.User;
import com.settlement.demo.service.DomainService;
import com.settlement.demo.service.UserService;
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
public class UserTests {

    @Autowired
    UserService userService;

    @Autowired
    DomainService domainService;

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {
        @Bean
        public UserService adminService() {
            return new UserService();
        }

        @Bean
        public DomainService domainService() {
            return new DomainService();
        }

    }

    @Test
    @Order(1)
    void createUser() throws Exception {
        Domain d = domainService.findDomainByDomainId(1L);

        if (d == null) {
            throw new Exception("Domain not found");
        }

        User u = new User();
        u.setMobile("+919560254331");
        u.setDomain(d);
        u.setName("shubham negi");

        User newDomain = userService.saveUser(u);
        assert newDomain.getId() != null;
    }

    @Test
    @Order(2)
    void findUsersByDomainId() {
        List<User> users = userService.findUserByDomain(1L);
        assert users.size() > 0;
    }

}
