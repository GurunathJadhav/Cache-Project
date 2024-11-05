package com.cacheproject.service;

import com.cacheproject.entity.Product;
import com.cacheproject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAll(){
        System.out.println("get all From db");
        return productRepository.findAll();
    }

    public Product getById(int id){
        System.out.println("From db");
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
    }

    public Product update(int id,Product product){
        Product old = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        old.setName(product.getName());
        old.setPrice(product.getPrice());
        return productRepository.save(old);
    }

    public String delete(int id){
        try {
            productRepository.deleteById(id);
            return "deleted";
        }catch (Exception e){
            return "Not deleted";
        }
    }
}
