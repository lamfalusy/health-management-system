package hu.lamsoft.hms.food;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

import hu.lamsoft.hms.common.restapi.annotation.HMSApplication;
import hu.lamsoft.hms.food.service.FoodServiceConfiguration;

@HMSApplication
@Import(FoodServiceConfiguration.class)
public class FoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodApplication.class, args);
	}
	
}
