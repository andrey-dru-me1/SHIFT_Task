package ru.cft.shift.task.test.melnikov.products.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.cft.shift.task.test.melnikov.products.Product;

import java.util.Collection;

public class ProductFactory {

    private final Collection<? extends Product> accessibleProducts;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public ProductFactory(Collection<? extends Product> accessibleProducts) {
        this.accessibleProducts = accessibleProducts;
    }

    public Product createProduct(String type, String jsonString) throws ClassNotFoundException {
        Class<? extends Product> clazz = stringToClass(type);
        return MAPPER.convertValue(jsonString, clazz);
    }

    private Class<? extends Product> stringToClass(String type) throws ClassNotFoundException {
        for (Product product: accessibleProducts) {
            if(product.getType().equals(type)) {
                return product.getClass();
            }
        }
        throw new ClassNotFoundException();
    }

}
