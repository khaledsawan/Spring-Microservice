package com.hexagon.saleservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.hexagon.saleservice.model.Sale;
import com.hexagon.saleservice.repository.SaleRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/sale")
public class SaleController {
    private final SaleRepository repository;

    public SaleController(SaleRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Sale createSale(@RequestBody Sale sale) {
        return repository.save(sale);
    }

    @GetMapping
    public List<Sale> getAllSales() {
        return repository.findAll();
    }

    @GetMapping("/company/{companyId}")
    public List<Sale> getSalesByCompany(@PathVariable String companyId) {
        return repository.findByCompanyId(companyId);
    }

    @GetMapping("/consumer/{consumerId}")
    public List<Sale> getSalesByConsumer(@PathVariable String consumerId) {
        return repository.findByConsumerId(consumerId);
    }
}
