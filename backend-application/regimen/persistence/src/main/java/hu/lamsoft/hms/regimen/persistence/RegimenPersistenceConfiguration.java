package hu.lamsoft.hms.regimen.persistence;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import hu.lamsoft.hms.common.persistence.HMSPersistenceConfiguration;

@Configuration
@EntityScan
@EnableJpaRepositories
@Import(HMSPersistenceConfiguration.class)
public class RegimenPersistenceConfiguration {

}
