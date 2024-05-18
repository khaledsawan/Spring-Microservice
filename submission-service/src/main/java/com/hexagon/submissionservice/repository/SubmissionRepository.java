package com.hexagon.submissionservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagon.submissionservice.model.Submission;


@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Integer> {
    List<Submission> findBySellerId(String sellerId);
    List<Submission> findByBuyerId(String buyerId);
}
