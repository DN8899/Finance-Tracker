package com.example.FinanceTracker.transaction;

import com.example.FinanceTracker.person.Person;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "transId")
    private Long transId;
    private LocalDate date;
    private double amount;
    private char type;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;


    public Transaction() {}


    public Transaction(Long transId, LocalDate date, double amount, char type) {
        this.transId = transId;
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public Transaction(LocalDate date, double amount, char type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public Transaction(double amount, char type) {
        this.amount = amount;
        this.type = type;
    }

    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transId=" + transId +
                ", date=" + date +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }
}
