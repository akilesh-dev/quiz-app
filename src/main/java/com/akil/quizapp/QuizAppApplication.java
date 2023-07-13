package com.akil.quizapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class QuizAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(QuizAppApplication.class, args);
	}

}
