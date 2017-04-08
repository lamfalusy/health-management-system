package hu.lamsoft.hms.common.restapi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import hu.lamsoft.hms.common.restapi.HMSRestApiConfiguration;
import hu.lamsoft.hms.common.restapi.security.HMSWebSecurityConfiguration;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@SpringBootApplication
@EnableDiscoveryClient
@Import({HMSWebSecurityConfiguration.class, HMSRestApiConfiguration.class})
public @interface HMSApplication {

}
