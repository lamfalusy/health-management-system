package hu.lamsoft.hms.common.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import hu.lamsoft.hms.common.persistence.HMSPersistenceConfiguration;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;

@Configuration
@ComponentScan
@Import(HMSPersistenceConfiguration.class)
public class HMSServiceConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
