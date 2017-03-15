package hu.lamsoft.hms.customer;

import org.springframework.boot.SpringApplication;

import hu.lamsoft.hms.common.restapi.annotation.HMSApplication;

@HMSApplication
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
}
