package com.hexagon.listingservice.service;

import org.springframework.stereotype.Service;

import com.hexagon.listingservice.model.Listing;
import com.hexagon.listingservice.repository.ListingRepository;

import java.util.List;

@Service
public class ListingService {
    private final ListingRepository repository;

    public ListingService(ListingRepository repository) {
        this.repository = repository;
    }

    public Listing createTransaction(Listing transaction) {
        return repository.save(transaction);
    }

    public List<Listing> getAllTransactions() {
        return repository.findAll();
    }

    public List<Listing> getTransactionsBySeller(String sellerId) {
        return repository.findBySellerId(sellerId);
    }

    public List<Listing> getTransactionsByBuyer(String buyerId) {
        return repository.findByBuyerId(buyerId);
    }
}