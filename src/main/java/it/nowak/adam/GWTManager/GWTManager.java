package it.nowak.adam.GWTManager;

import it.nowak.adam.GWTManager.DataGenerators.UsersGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GWTManager {
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(GWTManager.class, args);
		UsersGenerator usersGenerator = new UsersGenerator();

	}

}
