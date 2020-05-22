package com.settlement.demo.repository;

import com.settlement.demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTransactionsByDomain_Id(Long domainId);

    List<Transaction> findTransactionsByDomain_IdAndUser_Id(Long domainId, Long userId);
}
