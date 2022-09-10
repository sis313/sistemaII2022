package ucb.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ucb.app.repository.CityRepository;

@SpringBootApplication
public class AppApplication {
	@Autowired
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
