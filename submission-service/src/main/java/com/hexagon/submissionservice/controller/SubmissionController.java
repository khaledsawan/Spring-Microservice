package com.hexagon.submissionservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.hexagon.submissionservice.model.Submission;
import com.hexagon.submissionservice.repository.SubmissionRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/submission")
public class SubmissionController {
    private final SubmissionRepository repository;

    public SubmissionController(SubmissionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Submission createListing(@RequestBody Submission transaction) {
        return repository.save(transaction);
    }
    @GetMapping("/{id}")
    public Optional<Submission> fetchListingById(@PathVariable int id){
        return repository.findById(id);
    }


    @GetMapping
    public List<Submission> getAllListings() {
        return repository.findAll();
    }

    @GetMapping("/seller/{sellerId}")
    public List<Submission> getListingsBySeller(@PathVariable String sellerId) {
        return repository.findBySellerId(sellerId);
    }

    @GetMapping("/buyer/{buyerId}")
    public List<Submission> getListingsByBuyer(@PathVariable String buyerId) {
        return repository.findByBuyerId(buyerId);
    }
}
