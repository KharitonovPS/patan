package org.plaminsky.patan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PatanApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatanApplication.class, args);
	}

}
