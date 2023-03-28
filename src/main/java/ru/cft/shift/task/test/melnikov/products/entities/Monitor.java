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
public class Monitor extends Product {

    private double diagonalInch;

    public Monitor(int id, long series, String producer, double price, long count, double diagonalInch) {
        super(id, series, producer, price, count);
        this.diagonalInch = diagonalInch;
    }
}
