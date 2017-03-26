package hu.lamsoft.hms.common.service.search;

import com.mysema.query.types.Predicate;

import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;

@FunctionalInterface
public interface SearchPredicateBuilder<T extends BaseSearchVO> {

	Predicate build(T t);
	
}
