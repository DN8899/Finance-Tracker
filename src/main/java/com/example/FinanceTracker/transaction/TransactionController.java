package com.example.FinanceTracker.transaction;

import com.example.FinanceTracker.person.Person;
import com.example.FinanceTracker.person.PersonRepository;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.security.Principal;

@RestController
@RequestMapping("auth/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/put")
    public Transaction setTrans(@RequestBody Transaction transaction) {
        return transactionService.setTransaction(transaction);
    }

    //Response Entity returns the response used from Spring
    @PostMapping("")
    public ResponseEntity<?> createTransaction(@AuthenticationPrincipal Person person) {
        System.out.println("This is username " + person.getUsername());
        Transaction newTransaction = transactionService.save(person);

        return ResponseEntity.ok(newTransaction);
    }

}
