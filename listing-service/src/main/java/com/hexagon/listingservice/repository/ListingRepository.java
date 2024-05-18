package com.hexagon.listingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagon.listingservice.model.Listing;

@Repository
public interface ListingRepository extends JpaRepository<Listing,Integer> {
    List<Listing> findBySellerId(String sellerId);
    List<Listing> findByBuyerId(String buyerId);
}
