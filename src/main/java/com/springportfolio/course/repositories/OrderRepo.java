package com.springportfolio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springportfolio.course.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
