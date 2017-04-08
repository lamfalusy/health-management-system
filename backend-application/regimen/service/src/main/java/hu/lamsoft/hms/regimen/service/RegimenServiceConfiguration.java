package hu.lamsoft.hms.regimen.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import hu.lamsoft.hms.common.service.HMSServiceConfiguration;
import hu.lamsoft.hms.regimen.persistence.RegimenPersistenceConfiguration;

@Configuration
@Import({HMSServiceConfiguration.class, RegimenPersistenceConfiguration.class})
public class RegimenServiceConfiguration {

}
