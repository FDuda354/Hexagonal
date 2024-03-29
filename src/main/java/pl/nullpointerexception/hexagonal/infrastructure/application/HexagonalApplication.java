package pl.nullpointerexception.hexagonal.infrastructure.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"pl.nullpointerexception.hexagonal.infrastructure.persistence.database"})
@EntityScan(basePackages = "pl.nullpointerexception.hexagonal.infrastructure.persistence.database")
@ComponentScan(basePackages = {"pl.nullpointerexception.hexagonal.infrastructure"})
public class HexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalApplication.class, args);
	}
}
