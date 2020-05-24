package com.settlement.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.settlement.demo.model.Transaction;
import com.settlement.demo.repository.TransactionRepository;
import com.settlement.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionQuery implements GraphQLQueryResolver {

    @Autowired
    private TransactionService transactionService;

    public Transaction getTransaction(Long transactionId) {
        return transactionService.findByTransactionId(transactionId);
    }

    public List<Transaction> getTransactions(Long domainId, Long userId) throws Exception {
        if (domainId != null && userId != null) {
            return transactionService.findAllTransactionsByDomainAndUser(domainId, userId);
        } else if (domainId != null) {
            return transactionService.findAllTransactionsByDomain(domainId);
        } else if (userId != null) {
            return transactionService.findTransactionsByUserId(userId);
        }
        return transactionService.findAllTransactions();
    }


}
