package com.sda.spring.thymleaf.service;

import com.sda.spring.thymleaf.model.Product;
import com.sda.spring.thymleaf.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    // update
    public void update(Product product) {
        log.info("update product {}", product);

        String name = product.getName();
        Optional<Product> optionalProduct = productRepository.findByNameIgnoreCase(name);
        if (optionalProduct.isPresent()) {
            Product foundProduct = optionalProduct.get();
            if (foundProduct.getName().equals(product.getName())) {
                productRepository.save(product);
            } else {
                log.error("product with name {} already exists", name);
                throw new ResourceAlreadyExistsException("product with name " + name + " already exists");
            }
        }
    }

    public void updateNew(Product product) {
        log.info("update product {}", product);

        String name = product.getName();
        productRepository.findByNameIgnoreCase(name)
                .filter(existingProduct -> existingProduct.getId().equals(product.getId()))
                .map(existingProduct -> productRepository.save(product))
                .orElseThrow(() -> {
                    log.error("product with name {} already exists", name);
                    throw new ResourceAlreadyExistsException("product with name " + name + " already exists");
                });
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
    @Transactional
    public void delete(Long id) {
        log.info("deleting by id");
        productRepository.deleteById(id);
    }
}
