package com.hexagon.cloudgateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/customerFallback")
    public ResponseEntity<String> customerFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                             .body("Customer Service is temporarily unavailable. Please try again later.");
    }

    @RequestMapping("/companyFallback")
    public ResponseEntity<String> companyFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                             .body("Company Service is temporarily unavailable. Please try again later.");
    }

    @RequestMapping("/transactionFallback")
    public ResponseEntity<String> transactionFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                             .body("Transaction Service is temporarily unavailable. Please try again later.");
    }

    @RequestMapping("/saleFallback")
    public ResponseEntity<String> saleFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                             .body("Sale Service is temporarily unavailable. Please try again later.");
    }

    @RequestMapping("/listingFallback")
    public ResponseEntity<String> listingFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                             .body("Listing Service is temporarily unavailable. Please try again later.");
    }
}
