package com.hexagon.submissionservice.service;

import org.springframework.stereotype.Service;

import com.hexagon.submissionservice.model.Submission;
import com.hexagon.submissionservice.repository.SubmissionRepository;

import java.util.List;

@Service
public class ListingService {
    private final SubmissionRepository repository;

    public ListingService(SubmissionRepository repository) {
        this.repository = repository;
    }

    public Submission createTransaction(Submission transaction) {
        return repository.save(transaction);
    }

    public List<Submission> getAllTransactions() {
        return repository.findAll();
    }

    public List<Submission> getTransactionsBySeller(String sellerId) {
        return repository.findBySellerId(sellerId);
    }

    public List<Submission> getTransactionsByBuyer(String buyerId) {
        return repository.findByBuyerId(buyerId);
    }
}