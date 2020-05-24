package com.settlement.demo.repository;

import com.settlement.demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByDomain_Id(Long domainId);

    List<Transaction> findByDomain_IdAndUser_Id(Long domainId, Long userId);

    List<Transaction> findByUserIdOrderByIdDesc(Long userId);

    Transaction findFirstByUserIdOrderById(Long userId);
}
