package hu.lamsoft.hms.common.service.search.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.mysema.query.types.Predicate;

import hu.lamsoft.hms.common.service.food.impl.FoodSearchPredicateBuilder;
import hu.lamsoft.hms.common.service.food.vo.FoodSearchVO;
import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;

@Component
public class SearchPredicateBuilderComponent {

	private SearchPredicateBuilderMap searchPredicateBuilderMap = new SearchPredicateBuilderMap();
	
	@PostConstruct
	private void init() {
		searchPredicateBuilderMap.put(FoodSearchVO.class, new FoodSearchPredicateBuilder());
	}
	
	public <T extends BaseSearchVO> Predicate build(T searchVO, Class<T> type) {
		return searchPredicateBuilderMap.get(type).build(searchVO);
	}
	
}
