package hu.lamsoft.hms.common.service.search.configuration;

import java.lang.reflect.ParameterizedType;

import org.reflections.Reflections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.lamsoft.hms.common.service.search.SearchPredicateBuilder;
import hu.lamsoft.hms.common.service.search.annotation.PredicateBuilder;
import hu.lamsoft.hms.common.service.search.impl.SearchPredicateBuilderContext;
import hu.lamsoft.hms.common.service.search.impl.SearchPredicateBuilderContextBuilder;
import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;

@Configuration
public class SearchPredicateBuilderConfiguration {
	
	@Bean
	public SearchPredicateBuilderContext searchPredicateBuilderComponent() throws InstantiationException, IllegalAccessException {
		SearchPredicateBuilderContextBuilder contextBuilder = new SearchPredicateBuilderContextBuilder();
		Reflections reflections = new Reflections("hu.lamsoft.hms");
		for(Class<?> predicateBuilderClass : reflections.getTypesAnnotatedWith(PredicateBuilder.class)) {
			addBuilder(contextBuilder, predicateBuilderClass);
		}
		return contextBuilder.build();
	}
	
	@SuppressWarnings("unchecked")
	private <T extends BaseSearchVO> void addBuilder(SearchPredicateBuilderContextBuilder contextBuilder, Class<?> predicateBuilderClass) {
		if(!SearchPredicateBuilder.class.isAssignableFrom(predicateBuilderClass)) {
			throw new IllegalArgumentException(predicateBuilderClass.getName()+" class does not implement SearchPredicateBuilder interface.");
		}
		Class<T> type = (Class<T>) ((ParameterizedType)predicateBuilderClass.getGenericSuperclass()).getActualTypeArguments()[0];
		try {
			contextBuilder.addSearchPredicateBuilder(type, (SearchPredicateBuilder<T>) predicateBuilderClass.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
}
