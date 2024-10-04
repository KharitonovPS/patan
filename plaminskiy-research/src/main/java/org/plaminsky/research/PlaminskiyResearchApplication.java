package org.plaminsky.research;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PlaminskiyResearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaminskiyResearchApplication.class, args);
	}

}
