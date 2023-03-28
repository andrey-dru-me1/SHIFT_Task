package ru.cft.shift.task.test.melnikov.products;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public void addProduct(Product product) {
        productRepository.save(product);
    }

}
