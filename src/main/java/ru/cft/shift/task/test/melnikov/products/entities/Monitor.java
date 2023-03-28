package ru.cft.shift.task.test.melnikov.products.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
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

    public Monitor(Long id, long series, String producer, double price, long count, double diagonalInch) {
        super(id, series, producer, price, count);
        this.diagonalInch = diagonalInch;
    }

    @Override
    public String getType() {
        return "monitor";
    }
}
