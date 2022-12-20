package com.springportfolio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springportfolio.course.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
