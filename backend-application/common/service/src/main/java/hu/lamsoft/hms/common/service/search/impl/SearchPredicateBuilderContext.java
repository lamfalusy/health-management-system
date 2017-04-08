package hu.lamsoft.hms.common.service.search.impl;

import com.mysema.query.types.Predicate;

import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;

public class SearchPredicateBuilderContext {

	private SearchPredicateBuilderMap searchPredicateBuilderMap;
	
	SearchPredicateBuilderContext(SearchPredicateBuilderMap searchPredicateBuilderMap) {
		this.searchPredicateBuilderMap = searchPredicateBuilderMap;
	}
	
	public <T extends BaseSearchVO> Predicate build(T searchVO, Class<T> type) {
		return searchPredicateBuilderMap.get(type).build(searchVO);
	}
	
}
