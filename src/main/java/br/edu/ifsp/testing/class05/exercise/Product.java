package br.edu.ifsp.testing.class05.exercise;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Product {

    private final String uuid;
    @Setter
    private String name;
    @Setter
    private double price;

    public Product(String uuid, String name, double price) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
    }

    public void updateProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
