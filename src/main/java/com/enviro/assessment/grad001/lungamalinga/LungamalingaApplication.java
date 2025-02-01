package com.enviro.assessment.grad001.lungamalinga;

import com.enviro.assessment.grad001.lungamalinga.controller.TimeController;
import com.enviro.assessment.grad001.lungamalinga.model.DisposalGuidelines;
import com.enviro.assessment.grad001.lungamalinga.model.RecyclingTips;
import com.enviro.assessment.grad001.lungamalinga.model.WasteCategories;
import com.enviro.assessment.grad001.lungamalinga.repo.DisposalGuidelinesRepo;
import com.enviro.assessment.grad001.lungamalinga.repo.RecyclingTipRepo;
import com.enviro.assessment.grad001.lungamalinga.repo.WasteCategoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LungamalingaApplication {

	TimeController formattedNow = new TimeController();

	public static void main(String[] args) {
		try{
			SpringApplication.run(LungamalingaApplication.class, args);
		} catch (Exception e){
			System.out.println("Error ::: " + e.getMessage());
		}
	}

	/**
	 * Seed some data [pre-work] [set-starter db records [2 records for each table]]
	 * */
	@Bean
	CommandLineRunner cmdLineRunner(RecyclingTipRepo repo, WasteCategoryRepo wasteRepo, DisposalGuidelinesRepo guideRepo){
		return args -> {
			// add waste tips
			repo.save( new RecyclingTips(null, 1, "reduce", formattedNow.getFormattedNow()) );
			repo.save( new RecyclingTips(null, 2, "reuse", formattedNow.getFormattedNow()) );

			// add disposal guidelines
			 guideRepo.save(new DisposalGuidelines( null, 2, "Think about the environment", formattedNow.getFormattedNow() ));
			 guideRepo.save(new DisposalGuidelines( null, 1, "Pikitup - Puck up the litter", formattedNow.getFormattedNow() ));

			// add waste categories
			wasteRepo.save( new WasteCategories( null, "Reuse", "dont throw away", formattedNow.getFormattedNow() ));
			wasteRepo.save( new WasteCategories( null, "Reduce", "use less", formattedNow.getFormattedNow() ));
		};
	}
}


