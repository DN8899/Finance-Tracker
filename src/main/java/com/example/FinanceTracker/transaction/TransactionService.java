package com.example.FinanceTracker.transaction;


import com.example.FinanceTracker.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;

@Service
public class TransactionService {

    @Autowired
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository repository) {
        this.transactionRepository = repository;
    }

    public Transaction setTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction save(Person person) {
        Transaction transaction = new Transaction();
        LocalDate date = LocalDate.now();
        transaction.setDate(date);
        transaction.setPerson(person);
        transaction.setType('G');
        return transactionRepository.save(transaction);
    }

}
