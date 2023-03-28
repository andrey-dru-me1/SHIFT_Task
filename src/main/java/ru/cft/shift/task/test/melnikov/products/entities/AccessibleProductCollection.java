package ru.cft.shift.task.test.melnikov.products.entities;

import ru.cft.shift.task.test.melnikov.products.Product;

import java.util.Map;

public class AccessibleProductCollection {

    private final Map<String, Class<? extends Product>> accessibleProducts;

    public AccessibleProductCollection(Map<String, Class<? extends Product>> accessibleProducts) {
        this.accessibleProducts = accessibleProducts;
    }

    public Class<? extends Product> typeToClass(String type) {
        return accessibleProducts.get(type);
    }

}
