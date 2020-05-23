package com.settlement.demo.repository;

import com.settlement.demo.model.TransactionDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDocumentRepository extends JpaRepository<TransactionDocument, Long> {

}
