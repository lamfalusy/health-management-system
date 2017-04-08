package hu.lamsoft.hms.common.service.search.impl;

import hu.lamsoft.hms.common.service.search.SearchPredicateBuilder;
import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;

public class SearchPredicateBuilderContextBuilder {

	private SearchPredicateBuilderMap searchPredicateBuilderMap = new SearchPredicateBuilderMap();
	
	public <T extends BaseSearchVO> void addSearchPredicateBuilder(Class<T> type, SearchPredicateBuilder<T> searchPredicateBuilder) {
		searchPredicateBuilderMap.put(type, searchPredicateBuilder);
	}
	
	public SearchPredicateBuilderContext build() {
		return new SearchPredicateBuilderContext(searchPredicateBuilderMap);
	}
	
}
