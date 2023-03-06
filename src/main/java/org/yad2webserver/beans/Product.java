package org.yad2webserver.beans;
import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    public Product() {}

    private String name;
    @Id
    private String code;
    private int quantity;
    private double price;
    public Product(String name, String code, int quantity, double price) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}