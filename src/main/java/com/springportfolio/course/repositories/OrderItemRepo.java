package com.springportfolio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springportfolio.course.entities.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, OrderItem> {

}
