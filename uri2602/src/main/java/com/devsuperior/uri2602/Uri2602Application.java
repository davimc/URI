package com.devsuperior.uri2602;

import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("teste db");
		customerRepository.search1("RS").stream().forEach(obj -> System.out.println(obj.getName()));
	}
}
