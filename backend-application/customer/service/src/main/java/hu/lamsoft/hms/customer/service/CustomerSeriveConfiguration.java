package hu.lamsoft.hms.customer.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import hu.lamsoft.hms.common.service.HMSServiceConfiguration;
import hu.lamsoft.hms.customer.persistence.CustomerPersistenceConfiguration;

@Configuration
@Import({HMSServiceConfiguration.class, CustomerPersistenceConfiguration.class})
public class CustomerSeriveConfiguration {

}
