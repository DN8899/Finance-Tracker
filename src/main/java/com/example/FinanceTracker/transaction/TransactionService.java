package com.example.FinanceTracker.transaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository repository) {
        this.transactionRepository = repository;
    }

    public Transaction setTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

}
