package com.hexagon.customerservice.controller;

import com.hexagon.customerservice.model.Customer;
import com.hexagon.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/{id}")
    public ResponseEntity<?> fetchCustomerById(@PathVariable int id){
        return customerService.fetchCustomerById(id);
    }
    @GetMapping
    public ResponseEntity<?> fetchCustomers(){
        return customerService.fetchCustomers();
    }
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

}
