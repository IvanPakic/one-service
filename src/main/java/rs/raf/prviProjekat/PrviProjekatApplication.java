package rs.raf.prviProjekat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PrviProjekatApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrviProjekatApplication.class, args);
	}

}
