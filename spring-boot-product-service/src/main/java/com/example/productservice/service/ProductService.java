package com.example.productservice.service;

import com.example.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Smartphone", 25000.0));
        products.add(new Product(2L, "Laptop", 75000.0));
        products.add(new Product(3L, "Headphones", 5000.0));
        products.add(new Product(4L, "Smartwatch", 15000.0));
        return products;
    }
}
