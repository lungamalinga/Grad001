package com.enviro.assessment.grad001.lungamalinga;

//import com.enviro.assessment.grad001.lungamalinga.model.RecyclingTip;
//import com.enviro.assessment.grad001.lungamalinga.repo.RecyclingTipRepo;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LungamalingaApplication {

	public static void main(String[] args) {
		try{
			SpringApplication.run(LungamalingaApplication.class, args);
		} catch (Exception e){
			System.out.println("Eror ::: " + e.getMessage());
		}
	}

	/**
	 * Seed some data [pre-work] [set-starter db records]
	 * */
//	@Bean
//	CommandLineRunner cmdLineRunner(RecyclingTipRepo repo){
//		return args -> {
//			// add data [set default values]
////			repo.save( new RecyclingTip(null, "Reduce", "Don\'t things you don\'t need.") );
//		};
//	}
}
