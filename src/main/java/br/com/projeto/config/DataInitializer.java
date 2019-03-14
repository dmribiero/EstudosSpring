package br.com.projeto.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.projeto.entity.User;
import br.com.projeto.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {

			createUser("Diogo", "diogo.diolin@gmail.com");
			createUser("Adaildes", "ada@gmail.com");
			createUser("Nilva", "nilva@gmail.com");
		}
		
		User user = userRepository.findByNameQuery("Nilva");
		System.out.println(user.getName());

	}

	public void createUser(String name, String email) {
		User user = new User(name,email);
		userRepository.save(user);
	}
}
