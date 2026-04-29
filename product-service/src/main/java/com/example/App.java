package com.example;

import com.example.model.Product;
import com.example.service.ProductService;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        System.out.println("--- All Product Names with Prices ---");
        List<String> namesWithPrice = productService.getProductNamesWithPrice();
        namesWithPrice.forEach(System.out::println);

        double threshold = 10000.0;
        System.out.println("\n--- Products Above Price: " + threshold + " ---");
        List<Product> expensiveProducts = productService.getProductsAbovePrice(threshold);
        expensiveProducts.forEach(p -> 
            System.out.println(p.getName() + " - " + p.getPrice())
        );

        System.out.println("\n--- Searching for Product with ID 2 ---");
        Optional<Product> productOpt = productService.getProductById(2L);
        productOpt.ifPresentOrElse(
            p -> System.out.println("Found: " + p.getName()),
            () -> System.out.println("Product not found!")
        );

        System.out.println("\n--- Searching for Product with ID 99 ---");
        productService.getProductById(99L).ifPresentOrElse(
            p -> System.out.println("Found: " + p.getName()),
            () -> System.out.println("Product not found!")
        );
    }
}