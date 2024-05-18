package com.hexagon.transaction1service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagon.transaction1service.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findBySellerId(String sellerId);
    List<Transaction> findByBuyerId(String buyerId);
}
