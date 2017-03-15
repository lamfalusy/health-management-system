package hu.lamsoft.hms.food;

import org.springframework.boot.SpringApplication;

import hu.lamsoft.hms.common.restapi.annotation.HMSApplication;

@HMSApplication
public class FoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodApplication.class, args);
	}
	
}
