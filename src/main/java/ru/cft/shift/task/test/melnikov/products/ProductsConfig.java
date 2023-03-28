package ru.cft.shift.task.test.melnikov.products;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.cft.shift.task.test.melnikov.products.entities.DesktopComputer;
import ru.cft.shift.task.test.melnikov.products.entities.HardDrive;
import ru.cft.shift.task.test.melnikov.products.entities.Laptop;
import ru.cft.shift.task.test.melnikov.products.entities.Monitor;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProductsConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            List<Product> products = new ArrayList<>(4);
            products.add(new DesktopComputer(1L, 15, "Intel", 15.4, 5, DesktopComputer.FormFactor.DESKTOP));
            products.add(new HardDrive(2L, 18, "AMD", 5.33, 77, 256L * 1024));
            products.add(new Laptop(3L, 1, "LOL", 9.87, 1, Laptop.Size.THIRTEEN));
            products.add(new Monitor(4L, 89, "Kek", 1.15, 0, 13));
            productRepository.saveAll(products);
        };
    }

}
