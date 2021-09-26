package com.sda.spring.thymleaf.service;

import com.sda.spring.thymleaf.model.Product;
import com.sda.spring.thymleaf.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // create
    public void save(Product product) {
        log.info("saving product");
        productRepository.save(product);
    }

    // find all
    public List<Product> findAll() {
        log.info("finding all products");
        return productRepository.findAll();
    }

    // find by id
    public Product findById(Long id) {
        log.info("finding by id");
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found"));
    }

    // delete
    public void delete(Long id) {
        log.info("deleting by id");
        productRepository.deleteById(id);
    }
}
