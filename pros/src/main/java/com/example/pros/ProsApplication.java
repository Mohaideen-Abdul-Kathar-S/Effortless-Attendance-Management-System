package com.example.pros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.pros.repository")
public class ProsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProsApplication.class, args);
		System.out.println("Effortless Attendance Management System");
	}

}
