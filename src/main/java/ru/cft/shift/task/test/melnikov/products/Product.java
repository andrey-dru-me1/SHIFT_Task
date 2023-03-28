package ru.cft.shift.task.test.melnikov.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long series;
    private String producer;
    private double price;
    private long count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
