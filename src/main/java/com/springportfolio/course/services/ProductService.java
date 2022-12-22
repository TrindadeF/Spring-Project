package com.springportfolio.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springportfolio.course.entities.Product;
import com.springportfolio.course.repositories.ProductRepo;

@Service
public class ProductService {
	
	@Autowired 
	private ProductRepo repo;
	
	public List<Product> findAll(){
		return repo.findAll(); 
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repo.findById(id);
		return obj.get();
	}

}
