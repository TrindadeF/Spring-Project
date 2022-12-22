package com.springportfolio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springportfolio.course.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
