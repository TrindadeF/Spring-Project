package com.springportfolio.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springportfolio.course.entities.Order;
import com.springportfolio.course.entities.User;
import com.springportfolio.course.enums.OrderStatus;
import com.springportfolio.course.repositories.OrderRepo;
import com.springportfolio.course.repositories.UserRepo;

@Configuration
@Profile("test")

public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UserRepo userRepository;
	
	@Autowired
	private OrderRepo orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", null, "123456");
		User u2 = new User("Alex Green", "alex@gmail.com", "97777777", null, "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.CANCELED, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.SHIPPED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.SHIPPED, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
