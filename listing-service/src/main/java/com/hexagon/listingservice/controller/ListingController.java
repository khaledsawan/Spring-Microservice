package com.hexagon.listingservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.hexagon.listingservice.model.Listing;
import com.hexagon.listingservice.repository.ListingRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/listing")
public class ListingController {
    private final ListingRepository repository;

    public ListingController(ListingRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Listing createListing(@RequestBody Listing transaction) {
        return repository.save(transaction);
    }
    @GetMapping("/{id}")
    public Optional<Listing> fetchListingById(@PathVariable int id){
        return repository.findById(id);
    }


    @GetMapping
    public List<Listing> getAllListings() {
        return repository.findAll();
    }

    @GetMapping("/seller/{sellerId}")
    public List<Listing> getListingsBySeller(@PathVariable String sellerId) {
        return repository.findBySellerId(sellerId);
    }

    @GetMapping("/buyer/{buyerId}")
    public List<Listing> getListingsByBuyer(@PathVariable String buyerId) {
        return repository.findByBuyerId(buyerId);
    }
}
