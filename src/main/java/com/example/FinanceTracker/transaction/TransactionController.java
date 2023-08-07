package com.example.FinanceTracker.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trans")
@CrossOrigin("*")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/put")
    public Transaction setTrans(@RequestBody Transaction transaction) {
        return transactionService.setTransaction(transaction);
    }

}
