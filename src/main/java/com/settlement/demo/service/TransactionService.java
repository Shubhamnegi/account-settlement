package com.settlement.demo.service;

import com.settlement.demo.enums.FlowType;
import com.settlement.demo.model.Domain;
import com.settlement.demo.model.Transaction;
import com.settlement.demo.model.User;
import com.settlement.demo.repository.TransactionRepository;
import org.intellij.lang.annotations.Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    DomainService domainService;

    @Autowired
    UserService userService;


    public Transaction saveTransaction(Long domainId, Long userId, Double amount, FlowType flowType, String comments, String paymentId) throws Exception {
        // TODO block race condition using redis

        Transaction lastTransaction = this.transactionRepository.findFirstByUserIdOrderById(userId);

        Domain domain = domainService.findDomainByDomainId(domainId);
        User user = userService.findUserByUserId(userId);

        Transaction newTransaction = new Transaction();
        newTransaction.setDomain(domain);
        newTransaction.setUser(user);
        newTransaction.setAmount(amount);
        newTransaction.setFlowType(flowType);
        newTransaction.setComments(comments);
        newTransaction.setPaymentId(paymentId);

        Double closingBalance = null;
        if (lastTransaction == null) {
            lastTransaction = new Transaction();
            lastTransaction.setClosingBalance(0);
        }
        if (flowType.equals(FlowType.DEBITED)) {
            newTransaction.setClosingBalance(lastTransaction.getClosingBalance() - amount);
        } else if (flowType.equals(FlowType.CREDITED)) {
            newTransaction.setClosingBalance(lastTransaction.getClosingBalance() + amount);
        } else {
            throw new Exception("Invalid flowtype");
        }
        return transactionRepository.save(newTransaction);
    }

    public Transaction findByTransactionId(Long transactionId) {
        return transactionRepository.findById(transactionId).orElse(null);
    }

    public List<Transaction> findTransactionsByUserId(Long userID) {
        return transactionRepository.findByUserIdOrderByIdDesc(userID);
    }

    public List<Transaction> findAllTransactionsByDomain(Long domainId) {
        return transactionRepository.findByDomain_Id(domainId);
    }

    public List<Transaction> findAllTransactionsByDomainAndUser(Long domainId, Long userId) {
        return transactionRepository.findByDomain_IdAndUser_Id(domainId, userId);
    }

    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }
}
