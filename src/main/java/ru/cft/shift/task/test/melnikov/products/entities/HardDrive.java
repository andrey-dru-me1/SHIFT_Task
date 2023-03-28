package ru.cft.shift.task.test.melnikov.products.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cft.shift.task.test.melnikov.products.Product;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class HardDrive extends Product {

    private long volumeMB;

    public HardDrive(Long id, long series, String producer, double price, long count, long volumeMB) {
        super(id, series, producer, price, count);
        this.volumeMB = volumeMB;
    }

    @Override
    public String getType() {
        return "hardDrive";
    }
}
