package ru.cft.shift.task.test.melnikov.products;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.task.test.melnikov.products.entities.*;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductFactory productFactory;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.productFactory = new ProductFactory(List.of(new DesktopComputer(), new HardDrive(), new Laptop(), new Monitor()));
    }

    @Transactional
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void addProductFromJson(String type, String jsonString) throws ClassNotFoundException {
        productRepository.save(productFactory.createProduct(type, jsonString));
    }

}
