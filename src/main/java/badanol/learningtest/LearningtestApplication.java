package badanol.learningtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class LearningtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningtestApplication.class, args);
	}

}