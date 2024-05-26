package com.hexagon.transactionservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.hexagon.transactionservice.model.Transaction;
import com.hexagon.transactionservice.repository.TransactionRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }
    @GetMapping("/{id}")
    public Optional<Transaction> fetchTransactionById(@PathVariable int id){
        return repository.findById(id);
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
