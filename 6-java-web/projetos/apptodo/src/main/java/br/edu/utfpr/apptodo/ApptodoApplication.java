package br.edu.utfpr.apptodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class ApptodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApptodoApplication.class, args);
	}

}
