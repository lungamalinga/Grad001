package com.enviro.assessment.grad001.lungamalinga;

import com.enviro.assessment.grad001.lungamalinga.model.Tips;
import com.enviro.assessment.grad001.lungamalinga.repo.TipRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LungamalingaApplication {

	public static void main(String[] args) {

		SpringApplication.run(LungamalingaApplication.class, args);

	}

	/**
	 * Seed some data [pre-work]
	 * */
	@Bean
	CommandLineRunner cmdLineRunner(TipRepo repo){
		return args -> {
			// add data [set default values]
			repo.save( new Tips(null, "pikitup", "Dobah udotu") );
		};
	}
}
