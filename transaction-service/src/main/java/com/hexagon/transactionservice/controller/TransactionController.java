package com.hexagon.transactionservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpServerErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hexagon.transactionservice.model.Transaction;
import com.hexagon.transactionservice.repository.TransactionRepository;
import com.hexagon.transactionservice.dto.CustomerResponse;

@CrossOrigin("*")
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionRepository repository;
    private final RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    public TransactionController(TransactionRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }
    @GetMapping("/{id}")
    public Optional<Transaction> fetchTransactionById(@PathVariable int id) {
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

    @GetMapping("/customer/{customerId}")
    public CustomerResponse getCustomerDetails(@PathVariable int customerId) {
        String customerServiceUrl = "http://CUSTOMER-SERVICE/customer/" + customerId;
        try {
            return restTemplate.getForObject(customerServiceUrl, CustomerResponse.class);
        } catch (HttpServerErrorException e) {
            logger.error("Error calling CUSTOMER-SERVICE: {}", e.getMessage());
            throw e;
        }
    }
}
