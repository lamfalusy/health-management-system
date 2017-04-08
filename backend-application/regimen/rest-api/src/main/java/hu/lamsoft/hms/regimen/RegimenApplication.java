package hu.lamsoft.hms.regimen;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

import hu.lamsoft.hms.common.restapi.annotation.HMSApplication;
import hu.lamsoft.hms.regimen.service.RegimenServiceConfiguration;

@HMSApplication
@Import(RegimenServiceConfiguration.class)
public class RegimenApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegimenApplication.class, args);
	}
	
}
