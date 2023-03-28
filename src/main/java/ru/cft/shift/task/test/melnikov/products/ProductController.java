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


    @PutMapping(value = "/edit/desktop/computer/{id}")
    public ResponseEntity<String> editDesktopComputer(@PathVariable("id") int id, @RequestBody DesktopComputer desktopComputer) {
        productService.editProduct(id, desktopComputer);
        return ResponseEntity.ok("Successfully edited");
    }

    @PutMapping(value = "/edit/hard/drive/{id}")
    public ResponseEntity<String> editHardDrive(@PathVariable("id") int id, @RequestBody HardDrive hardDrive) {
        productService.editProduct(id, hardDrive);
        return ResponseEntity.ok("Successfully edited");
    }

    @PutMapping(value = "/edit/laptop/{id}")
    public ResponseEntity<String> editLaptop(@PathVariable("id") int id, @RequestBody Laptop laptop) {
        productService.editProduct(id, laptop);
        return ResponseEntity.ok("Successfully edited");
    }

    @PutMapping(value = "/edit/monitor/{id}")
    public ResponseEntity<String> editMonitor(@PathVariable("id") int id, @RequestBody Monitor monitor) {
        productService.editProduct(id, monitor);
        return ResponseEntity.ok("Successfully edited");
    }

}
