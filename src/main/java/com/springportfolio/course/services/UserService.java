package com.springportfolio.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.springportfolio.course.entities.User;
import com.springportfolio.course.repositories.UserRepo;
import com.springportfolio.course.services.exception.DataBaseException;
import com.springportfolio.course.services.exception.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired 
	private UserRepo repo;
	
	public List<User> findAll(){
		return repo.findAll(); 
	}
	
	public User findById(Long id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repo.deleteById(id);
		} catch (EmptyResultDataAccessException e ) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		User entity = findById(id);
		updateData(entity, obj);
		return repo.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
