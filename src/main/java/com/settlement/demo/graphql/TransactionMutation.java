package com.settlement.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.settlement.demo.enums.FlowType;
import com.settlement.demo.model.Transaction;
import com.settlement.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionMutation implements GraphQLMutationResolver {

    @Autowired
    TransactionService transactionService;

    public Transaction createTransaction(Long domainId, Long userId, Double amount, FlowType flowType, String comments, String paymentId) throws Exception {
        return transactionService.saveTransaction(domainId, userId, amount, flowType, comments, paymentId);
    }
}
