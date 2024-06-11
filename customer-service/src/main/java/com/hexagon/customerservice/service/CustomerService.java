package com.hexagon.customerservice.service;



import com.hexagon.customerservice.dto.CustomerResponse;
import com.hexagon.customerservice.model.Customer;
import com.hexagon.customerservice.repository.CustomerRepository;

import lombok.Value;

import com.hexagon.customerservice.dto.Company;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> createCustomer(Customer customer){
        try{
            return new ResponseEntity<Customer>(customerRepository.save(customer), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    public ResponseEntity<?> fetchCustomerById(int id){
        Optional<Customer> customer =  customerRepository.findById(id);
        System.out.println("hi form  ");
        if(customer.isPresent()){
            Company comapny = restTemplate.getForObject("http://COMPANY-SERVICE/company/" + customer.get().getCompanyId(), Company.class);
            CustomerResponse customerResponse = new CustomerResponse(
                    customer.get().getId(),
                    customer.get().getName(),
                    customer.get().getAge(),
                    customer.get().getGender(),
                    
                    comapny
            );
            return new ResponseEntity<>(customerResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No customer Found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fetchCustomers(){
        List<Customer> customer = customerRepository.findAll();
        if(customer.size() > 0){
            return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Customers",HttpStatus.NOT_FOUND);
        }
    }

}
