package com.cacheproject.repository;

import com.cacheproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

     static final String HASH_KEY="product";
}