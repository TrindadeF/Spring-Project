package com.springportfolio.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springportfolio.course.entities.Category;
import com.springportfolio.course.entities.Order;
import com.springportfolio.course.entities.OrderItem;
import com.springportfolio.course.entities.Payment;
import com.springportfolio.course.entities.Product;
import com.springportfolio.course.entities.User;
import com.springportfolio.course.enums.OrderStatus;
import com.springportfolio.course.repositories.CategoryRepo;
import com.springportfolio.course.repositories.OrderItemRepo;
import com.springportfolio.course.repositories.OrderRepo;
import com.springportfolio.course.repositories.ProductRepo;
import com.springportfolio.course.repositories.UserRepo;

@Configuration
@Profile("test")

public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UserRepo userRepository;
	
	@Autowired
	private OrderRepo orderRepository;
	
	@Autowired
	private CategoryRepo categoryRepository;
	
	@Autowired
	private ProductRepo productRepository;
	
	@Autowired
	private OrderItemRepo orderitemrepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "", null);
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "", null);
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "", null);
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "", null);
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "", null); 
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
		
		User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", null, "123456");
		User u2 = new User("Alex Green", "alex@gmail.com", "97777777", null, "123456");
		User u3 = new User("Luiz Felipe", "felipe@gmail.com", "98184184", null, "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.Paid, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.Paid, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.DELIVERED, u1);

		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderitemrepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-07-22T16:21:22Z"), o3);
		Payment pay2 = new Payment(null, Instant.parse("2019-07-21T04:42:10Z") , o2);
		Payment pay3 = new Payment(null, Instant.parse("2019-06-20T20:53:07Z") , o1);
		
		o1.setPayment(pay1);
		o2.setPayment(pay2);
		o3.setPayment(pay3);
		
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
		
	}

}
