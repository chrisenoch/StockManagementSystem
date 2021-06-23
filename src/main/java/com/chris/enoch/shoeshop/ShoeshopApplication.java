package com.chris.enoch.shoeshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chris.enoch.shoeshop.dao.ShoeRepository;



@SpringBootApplication
public class ShoeshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoeshopApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner data(ShoeRepository repo) {
//		return (args) -> {
//			repo.insert();
//		};
//	}

}
