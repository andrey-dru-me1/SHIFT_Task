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
public class DesktopComputer extends Product {

    private FormFactor formFactor;

    public DesktopComputer(int id, long series, String producer, double price, long count, FormFactor formFactor) {
        super(id, series, producer, price, count);
        this.formFactor = formFactor;
    }

    public enum FormFactor {
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }

}
