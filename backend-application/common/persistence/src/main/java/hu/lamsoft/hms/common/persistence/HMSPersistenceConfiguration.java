package hu.lamsoft.hms.common.persistence;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan
@EnableJpaRepositories
public class HMSPersistenceConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(HMSPersistenceConfiguration.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Value("${flyway.migration.enabled:true}")
	private Boolean migareteEnabled;
	
	@Bean
	public Flyway flyway(Environment env) {
		LOGGER.info("Database migration is {}.", migareteEnabled ? "enabled" : "disabled");
		Flyway flyway = new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setDataSource(dataSource);
		flyway.setLocations("classpath:db/schema");
		if(migareteEnabled) {
			flyway.migrate();
			LOGGER.info("Database migration process finished.");
		}
		return flyway;
	}
	
}
