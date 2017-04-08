package hu.lamsoft.hms.common.service.search.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.mysema.query.types.Predicate;

import hu.lamsoft.hms.common.service.food.predicate.FoodSearchPredicateBuilder;
import hu.lamsoft.hms.common.service.food.predicate.RecipeSearchPredicateBuilder;
import hu.lamsoft.hms.common.service.food.vo.FoodSearchVO;
import hu.lamsoft.hms.common.service.food.vo.RecipeSearchVO;
import hu.lamsoft.hms.common.service.nutritionist.predicate.BlogEntrySearchPredicateBuilder;
import hu.lamsoft.hms.common.service.nutritionist.predicate.NutritionistSearchPredicateBuilder;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntrySearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistSearchVO;
import hu.lamsoft.hms.common.service.regimen.predicate.RegimenSearchPredicateBuilder;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenSearchVO;
import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;

@Component
public class SearchPredicateBuilderComponent {

	private SearchPredicateBuilderMap searchPredicateBuilderMap = new SearchPredicateBuilderMap();
	
	@PostConstruct
	private void init() {
		searchPredicateBuilderMap.put(FoodSearchVO.class, new FoodSearchPredicateBuilder());
		searchPredicateBuilderMap.put(RecipeSearchVO.class, new RecipeSearchPredicateBuilder());
		searchPredicateBuilderMap.put(RegimenSearchVO.class, new RegimenSearchPredicateBuilder());
		searchPredicateBuilderMap.put(NutritionistSearchVO.class, new NutritionistSearchPredicateBuilder());
		searchPredicateBuilderMap.put(BlogEntrySearchVO.class, new BlogEntrySearchPredicateBuilder());
	}
	
	public <T extends BaseSearchVO> Predicate build(T searchVO, Class<T> type) {
		return searchPredicateBuilderMap.get(type).build(searchVO);
	}
	
}
