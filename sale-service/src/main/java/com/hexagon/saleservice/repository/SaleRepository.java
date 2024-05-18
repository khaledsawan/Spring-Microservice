package com.hexagon.saleservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagon.saleservice.model.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Integer> {
    List<Sale> findByCompanyId(String companyId);
    List<Sale> findByConsumerId(String consumerId);
}
