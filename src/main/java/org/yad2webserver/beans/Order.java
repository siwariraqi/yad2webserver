package org.yad2webserver.beans;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orderss")
public class Order {

    private String transactionDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String transactionNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    private double transactionAmount;

    public Order(String transactionNumber, String transactionDate, List<Product> products, double transactionAmount) {
        this.transactionNumber = transactionNumber;
        this.transactionDate = transactionDate;
        this.products = products;
        this.transactionAmount = transactionAmount;
    }

    public Order() {

    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
