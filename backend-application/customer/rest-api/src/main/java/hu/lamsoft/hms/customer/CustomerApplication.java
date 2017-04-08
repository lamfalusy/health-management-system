package hu.lamsoft.hms.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

import hu.lamsoft.hms.common.restapi.annotation.HMSApplication;
import hu.lamsoft.hms.customer.service.CustomerSeriveConfiguration;

@HMSApplication
@Import(CustomerSeriveConfiguration.class)
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
}
