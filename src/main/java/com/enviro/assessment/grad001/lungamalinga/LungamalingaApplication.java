package com.enviro.assessment.grad001.lungamalinga;

//import com.enviro.assessment.grad001.lungamalinga.model.RecyclingTip;
//import com.enviro.assessment.grad001.lungamalinga.repo.RecyclingTipRepo;
//import org.springframework.boot.CommandLineRunner;
import com.enviro.assessment.grad001.lungamalinga.model.RecyclingTips;
import com.enviro.assessment.grad001.lungamalinga.repo.RecyclingTipRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LungamalingaApplication {



	// Get the current date and time
	LocalDateTime now = LocalDateTime.now();

	// Define the format
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	// Format the current date and time
	String formattedNow = now.format(formatter);

	public static void main(String[] args) {
		try{
			SpringApplication.run(LungamalingaApplication.class, args);
		} catch (Exception e){
			System.out.println("Error ::: " + e.getMessage());
		}
	}

	/**
	 * Seed some data [pre-work] [set-starter db records]
	 * */
	@Bean
	CommandLineRunner cmdLineRunner(RecyclingTipRepo repo){
		return args -> {
			// add data [set default values]
			repo.save( new RecyclingTips(null, "1", "Don\'t things you don\'t need.", formattedNow) );
		};
	}
}
