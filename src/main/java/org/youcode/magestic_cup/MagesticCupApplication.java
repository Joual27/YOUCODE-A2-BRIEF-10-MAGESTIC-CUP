package org.youcode.magestic_cup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MagesticCupApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagesticCupApplication.class, args);
	}

}
