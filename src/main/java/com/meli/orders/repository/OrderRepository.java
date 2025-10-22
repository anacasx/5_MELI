package com.meli.orders.repository;

import com.meli.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Order entity operations.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {}