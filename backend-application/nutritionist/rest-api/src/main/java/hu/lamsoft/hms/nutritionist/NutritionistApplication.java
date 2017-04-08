package hu.lamsoft.hms.nutritionist;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

import hu.lamsoft.hms.common.restapi.annotation.HMSApplication;
import hu.lamsoft.hms.nutritionist.service.NutritionistServiceConfiguration;

@HMSApplication
@Import(NutritionistServiceConfiguration.class)
public class NutritionistApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutritionistApplication.class, args);
	}
	
}
