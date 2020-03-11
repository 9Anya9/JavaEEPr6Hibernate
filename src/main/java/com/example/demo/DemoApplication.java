package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

		UserService userService = applicationContext.getBean(UserService.class);
		UserEntity user1 = userService.createUser("Anna", "Salii", "annasaliy909@gmail.com");
		UserEntity user2 = userService.createUser("Lera", "Mykhalova", "lerochka@gmail.com");
		UserEntity user3 = userService.createUser("Andrii", "Ivaskevich", "andrii909@gmail.com");
		UserEntity user4 = userService.createUser("Anna", "Gomilko", "gomilko909@gmail.com");
		UserEntity user5 = userService.createUser("Oleg", "Gomilko", "sunmoon56@gmail.com");
		UserEntity user6 = userService.createUser("Andrii", "Moroz", "moroza@gmail.com");

		System.out.println("\nUsers (names contain a word/letter): ");
		List<UserEntity> foundByWord = userService.getUserByLetter("z");
		for (UserEntity user: foundByWord) {
			System.out.println(user);
		}

		System.out.println("\nUsers (names contain a word/letter): ");
		List<UserEntity> foundByWord1 = userService.getUserByLetter("Myk");
		for (UserEntity user: foundByWord1) {
			System.out.println(user);
		}

		System.out.println("\nUser by surname: ");
		List<UserEntity> foundBySurname = userService.getUserSurname("Gomilko");
		for (UserEntity user: foundBySurname) {
			System.out.println(user);
		}

		System.out.println("\nAll users: ");
		List<UserEntity> allUsers = userService.getUsers();
		for (UserEntity user: allUsers ) {
			System.out.println(user);
		}
	}

}
