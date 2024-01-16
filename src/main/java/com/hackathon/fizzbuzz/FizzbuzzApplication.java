package com.hackathon.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hackathon.fizzbuzz"})
public class FizzbuzzApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(FizzbuzzApplication.class, args);
	}

}
