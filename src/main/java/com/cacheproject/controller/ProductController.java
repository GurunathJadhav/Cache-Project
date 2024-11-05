package com.cacheproject.controller;

import com.cacheproject.entity.Product;
import com.cacheproject.service.ProductService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/register-product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    @Cacheable(value = "product")
    public ResponseEntity<List> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id",value = "product")
    public ResponseEntity<Product> getById(@PathVariable int id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @PutMapping("/{id}")
    @CachePut(value = "product")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product){
        return ResponseEntity.ok(productService.update(id,product));
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key="#id",value = "product")
    public ResponseEntity<String> delete(@PathVariable int id){
        return ResponseEntity.ok(productService.delete(id));
    }
}
