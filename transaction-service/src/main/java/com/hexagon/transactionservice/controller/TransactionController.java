package com.hexagon.transactionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexagon.transactionservice.model.Transaction;
import com.hexagon.transactionservice.repository.TransactionRepository;
import com.hexagon.transactionservice.service.TransactionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class TransactionController {
    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    @GetMapping("/seller/{sellerId}")
    public List<Transaction> getTransactionsBySeller(@PathVariable String sellerId) {
        return repository.findBySellerId(sellerId);
    }

    @GetMapping("/buyer/{buyerId}")
    public List<Transaction> getTransactionsByBuyer(@PathVariable String buyerId) {
        return repository.findByBuyerId(buyerId);
    }
}
