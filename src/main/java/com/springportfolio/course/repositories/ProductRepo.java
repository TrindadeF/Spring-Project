package com.springportfolio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springportfolio.course.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
