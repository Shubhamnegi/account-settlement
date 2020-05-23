package com.settlement.demo.service;

import com.settlement.demo.model.TransactionDocument;
import com.settlement.demo.repository.TransactionDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionDocumentService {

    @Autowired
    private TransactionDocumentRepository transactionDocumentRepository;

    TransactionDocument save(TransactionDocument td) {
        return transactionDocumentRepository.save(td);
    }

}
