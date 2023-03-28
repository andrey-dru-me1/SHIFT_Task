package ru.cft.shift.task.test.melnikov.products;

import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.task.test.melnikov.products.entities.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final AccessibleProductCollection accessibleProductCollection;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.accessibleProductCollection = new AccessibleProductCollection(Map.of(
                "desktopComputer", DesktopComputer.class,
                "hardDrive", HardDrive.class,
                "laptop", Laptop.class,
                "monitor", Monitor.class
        ));
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
    public void editProduct(int id, @NotNull Product product) {
        productRepository.findById(id);
        product.setId(id);
        productRepository.save(product);
    }

    @Transactional
    public void removeProduct(int id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public Collection<Product> findByType(String type) {
        return productRepository
                .findAll()
                .stream()
                .filter(product -> product.getClass() == accessibleProductCollection.typeToClass(type))
                .toList();
    }

    @Transactional
    public Product findById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

}
