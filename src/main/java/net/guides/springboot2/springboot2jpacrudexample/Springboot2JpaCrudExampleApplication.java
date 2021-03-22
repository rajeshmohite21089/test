package net.guides.springboot2.springboot2jpacrudexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Springboot2JpaCrudExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2JpaCrudExampleApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder  bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
		
		
	}
}
