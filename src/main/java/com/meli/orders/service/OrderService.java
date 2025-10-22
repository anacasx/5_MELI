package com.meli.orders.service;

import com.meli.orders.entity.Order;
import com.meli.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing order-related operations.
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    /**
     * Creates a new order.
     * @param order The order to be created.
     * @return The saved order.
     */
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    /**
     * Retrieves an order by its ID.
     * @param id The ID of the order.
     * @return The order if found, otherwise null.
     */
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves all orders.
     * @return List of all orders.
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Updates an existing order.
     * @param id The ID of the order to update.
     * @param orderDetails The updated order details.
     * @return The updated order.
     */
    public Order updateOrder(Long id, Order orderDetails) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setCustomerId(orderDetails.getCustomerId());
            order.setProductDetails(orderDetails.getProductDetails());
            order.setTotal(orderDetails.getTotal());
            order.setOrderDate(orderDetails.getOrderDate());
            return orderRepository.save(order);
        }
        return null;
    }

    /**
     * Deletes an order by its ID.
     * @param id The ID of the order to delete.
     */
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}