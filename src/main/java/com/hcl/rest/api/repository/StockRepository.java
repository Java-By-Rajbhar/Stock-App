package com.hcl.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.rest.api.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

}
