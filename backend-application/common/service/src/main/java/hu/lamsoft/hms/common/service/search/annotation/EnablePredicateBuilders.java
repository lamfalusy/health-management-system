package hu.lamsoft.hms.common.service.search.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import hu.lamsoft.hms.common.service.search.configuration.SearchPredicateBuilderConfiguration;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(SearchPredicateBuilderConfiguration.class)
public @interface EnablePredicateBuilders {

}
