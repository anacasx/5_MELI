package com.meli.orders.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Represents an order in the online store.
 */
@Entity
@Table(name = "orders")
public class Order {
    /**
     * Unique identifier for the order.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Identifier of the customer who placed the order.
     */
    private String customerId;

    /**
     * Details of the products in the order.
     */
    private String productDetails;

    /**
     * Total amount of the order.
     */
    private double total;

    /**
     * Date and time when the order was created.
     */
    private LocalDateTime orderDate;

    // Constructor vacío requerido por JPA
    public Order() {}

    // Constructor con parámetros
    public Order(String customerId, String productDetails, double total, LocalDateTime orderDate) {
        this.customerId = customerId;
        this.productDetails = productDetails;
        this.total = total;
        this.orderDate = orderDate;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public String getProductDetails() { return productDetails; }
    public void setProductDetails(String productDetails) { this.productDetails = productDetails; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
}