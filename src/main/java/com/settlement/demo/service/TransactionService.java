package com.settlement.demo.service;

import com.settlement.demo.model.Transaction;
import com.settlement.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction t) {
        return transactionRepository.save(t);
    }

    public List<Transaction> findAllTransactionsByDomain(Long domainId) {
        return transactionRepository.findTransactionsByDomain_Id(domainId);
    }

    public List<Transaction> findAllTransactionsByDomainAndUser(Long domainId, Long userId) {
        return transactionRepository.findTransactionsByDomain_IdAndUser_Id(domainId, userId);
    }
}
