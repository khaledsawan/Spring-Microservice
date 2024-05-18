package com.hexagon.transaction1service.service;

import org.springframework.stereotype.Service;

import com.hexagon.transaction1service.model.Transaction;
import com.hexagon.transaction1service.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public List<Transaction> getTransactionsBySeller(String sellerId) {
        return repository.findBySellerId(sellerId);
    }

    public List<Transaction> getTransactionsByBuyer(String buyerId) {
        return repository.findByBuyerId(buyerId);
    }
}