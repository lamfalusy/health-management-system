package hu.lamsoft.hms.nutritionist.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import hu.lamsoft.hms.common.service.HMSServiceConfiguration;
import hu.lamsoft.hms.nutritionist.persistence.NutritionistPersistenceConfiguration;

@Configuration
@Import({HMSServiceConfiguration.class, NutritionistPersistenceConfiguration.class})
public class NutritionistServiceConfiguration {

}
