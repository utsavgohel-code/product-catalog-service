package com.example.productservice.service;

import com.example.productservice.model.Product;
import com.example.productservice.dto.ProductDTO;
import com.example.productservice.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private Long nextId = 5L;

    public ProductService() {
        products.add(new Product(1L, "Smartphone", 25000.0));
        products.add(new Product(2L, "Laptop", 75000.0));
        products.add(new Product(3L, "Headphones", 5000.0));
        products.add(new Product(4L, "Smartwatch", 15000.0));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
    }

    public Product addProduct(ProductDTO productDTO) {
        Product product = new Product(nextId++, productDTO.getName(), productDTO.getPrice());
        products.add(product);
        return product;
    }
}
