package com.sda.spring.thymleaf.config;

import com.sda.spring.thymleaf.model.Product;
import com.sda.spring.thymleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbInit {

    @Autowired
    private ProductService productService;

    @Bean
    public CommandLineRunner initialData() {
        return args -> {
            // load initial data in db
            Product product = new Product("tv", 5000.99);
            Product phone = new Product("phone", 4000.99);
            productService.save(product);
            productService.save(phone);
        };
    }
}
