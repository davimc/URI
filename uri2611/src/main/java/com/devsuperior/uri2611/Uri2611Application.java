package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Autowired
	private MovieRepository movieRepository;
	@Override
	public void run(String... args) throws Exception {
		for(MovieMinProjection m: movieRepository.search1("Action"))
			System.out.println(new MovieMinDTO(m));

		for(MovieMinDTO m: movieRepository.search2("Action"))
			System.out.println(m);
	}
}
