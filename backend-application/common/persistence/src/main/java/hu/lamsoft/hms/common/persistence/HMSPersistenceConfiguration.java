package hu.lamsoft.hms.common.persistence;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan
@EnableJpaRepositories
public class HMSPersistenceConfiguration {

	@Autowired
	private DataSource dataSource;
	
	@Bean(initMethod = "migrate")
	public Flyway flyway(Environment env) {
		Flyway flyway = new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setDataSource(dataSource);
		flyway.setLocations("classpath:db/schema");
		return flyway;
	}
	
}
