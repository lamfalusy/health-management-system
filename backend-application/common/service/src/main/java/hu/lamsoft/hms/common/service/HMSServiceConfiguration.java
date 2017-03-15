package hu.lamsoft.hms.common.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import hu.lamsoft.hms.common.persistence.HMSPersistenceConfiguration;

@Configuration
@ComponentScan
@Import(HMSPersistenceConfiguration.class)
public class HMSServiceConfiguration {

}
