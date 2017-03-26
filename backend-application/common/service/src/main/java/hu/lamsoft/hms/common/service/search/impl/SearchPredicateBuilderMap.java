package hu.lamsoft.hms.common.service.search.impl;

import java.util.HashMap;
import java.util.Map;

import hu.lamsoft.hms.common.service.search.SearchPredicateBuilder;
import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;

public class SearchPredicateBuilderMap {

	private Map<Class<? extends BaseSearchVO>, SearchPredicateBuilder<? extends BaseSearchVO>> map = new HashMap<>();
	
	public SearchPredicateBuilderMap() {
		// Nothing to do here
	}
	
	@SuppressWarnings("unchecked")
	public <T extends BaseSearchVO> SearchPredicateBuilder<T> put(Class<T> type, SearchPredicateBuilder<T> searchPredicateBuilder) {
		return (SearchPredicateBuilder<T>) map.put(type, searchPredicateBuilder);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends BaseSearchVO> SearchPredicateBuilder<T> get(Class<T> type) {
		return (SearchPredicateBuilder<T>) map.get(type);
	}
	
}
