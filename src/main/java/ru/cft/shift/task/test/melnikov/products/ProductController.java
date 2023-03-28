package ru.cft.shift.task.test.melnikov.products;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.task.test.melnikov.products.entities.DesktopComputer;
import ru.cft.shift.task.test.melnikov.products.entities.HardDrive;
import ru.cft.shift.task.test.melnikov.products.entities.Laptop;
import ru.cft.shift.task.test.melnikov.products.entities.Monitor;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/get/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping(value = "/add/desktop/computer")
    public ResponseEntity<String> addDesktopComputer(@RequestBody DesktopComputer desktopComputer) {
        productService.addProduct(desktopComputer);
        return ResponseEntity.ok("Successfully added");
    }

    @PostMapping(value = "/add/hard/drive")
    public ResponseEntity<String> addHardDrive(@RequestBody HardDrive hardDrive) {
        productService.addProduct(hardDrive);
        return ResponseEntity.ok("Successfully added");
    }

    @PostMapping(value = "/add/laptop")
    public ResponseEntity<String> addLaptop(@RequestBody Laptop laptop) {
        productService.addProduct(laptop);
        return ResponseEntity.ok("Successfully added");
    }

    @PostMapping(value = "/add/monitor")
    public ResponseEntity<String> addMonitor(@RequestBody Monitor monitor) {
        productService.addProduct(monitor);
        return ResponseEntity.ok("Successfully added");
    }

    @PostMapping(value = "add/product/{type}")
    public ResponseEntity<String> addProduct(@PathVariable("type") String type, @RequestBody String json) {
        try {
            productService.addProductFromJson(type, json);
        } catch (ClassNotFoundException e) {
            return ResponseEntity.badRequest().body("Type is wrong.");
        }
        return ResponseEntity.ok("A product has added successfully!");
    }

}
