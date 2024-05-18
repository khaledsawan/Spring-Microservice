package com.hexagon.saleservice.service;

import org.springframework.stereotype.Service;

import com.hexagon.saleservice.model.Sale;
import com.hexagon.saleservice.repository.SaleRepository;

import java.util.List;

@Service
public class SaleService {
    private final SaleRepository repository;

    public SaleService(SaleRepository repository) {
        this.repository = repository;
    }

    public Sale createSale(Sale sale) {
        return repository.save(sale);
    }

    public List<Sale> getAllSales() {
        return repository.findAll();
    }

    public List<Sale> getSalesByCompany(String companyId) {
        return repository.findByCompanyId(companyId);
    }

    public List<Sale> getSalesByConsumer(String consumerId) {
        return repository.findByConsumerId(consumerId);
    }
}