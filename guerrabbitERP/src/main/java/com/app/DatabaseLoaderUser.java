package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.app.entity.*;

import com.app.repository.UserRepository;

@Component
@ComponentScan(basePackages={"com.app"})
public class DatabaseLoaderUser implements CommandLineRunner { 

	private final UserRepository repository;

	@Autowired 
	public DatabaseLoaderUser(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
			
		User user = new User();
		user.setId(1);
		user.setName("Capacitacion");
		user.setEmail("perezjuang@hotmail.com");
		this.repository.save(user);
				
	}
}
