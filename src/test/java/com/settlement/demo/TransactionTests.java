package com.settlement.demo;

import com.settlement.demo.enums.FlowType;
import com.settlement.demo.model.Domain;
import com.settlement.demo.model.Transaction;
import com.settlement.demo.model.User;
import com.settlement.demo.service.DomainService;
import com.settlement.demo.service.TransactionService;
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

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransactionTests {

    @Autowired
    TransactionService transactionService;

    @Autowired
    DomainService domainService;

    @Autowired
    UserService userService;

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

        @Bean
        public TransactionService transactionService() {
            return new TransactionService();
        }

    }

    @Test
    @Order(1)
    void testSaveTransaction() {
        Domain d = domainService.findDomainByDomainId(1L);
        User u = userService.findUserByDomainAndMobile(1L, "+919560254331");

        Transaction t = new Transaction();
        t.setDomain(d);
        t.setAmount(10);
        t.setFlowType(FlowType.DEBITED);
        t.setUser(u);
        t.setClosingBalance(-10);
        t.setPaymentId(null);
        t.setComments("Test Transaction");

        Transaction newT = transactionService.saveTransaction(t);
        assert newT.getId() != null;

    }

}