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
public class Laptop extends Product {

    private Size sizeInch;

    public Laptop(Long id, long series, String producer, double price, long count, Size sizeInch) {
        super(id, series, producer, price, count);
        this.sizeInch = sizeInch;
    }

    @Getter
    public enum Size {
        THIRTEEN(13),
        FOURTEEN(14),
        FIFTEEN(15),
        SEVENTEEN(17);

        private final int value;

        Size(int value) {
            this.value = value;
        }
    }

}
