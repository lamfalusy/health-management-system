package hu.lamsoft.hms.food.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import hu.lamsoft.hms.common.service.HMSServiceConfiguration;
import hu.lamsoft.hms.food.persistence.FoodPersistenceConfiguration;

@Configuration
@Import({HMSServiceConfiguration.class, FoodPersistenceConfiguration.class})
public class FoodServiceConfiguration {

}
