package hu.lamsoft.hms.common.service.search.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.expr.StringExpression;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;

import hu.lamsoft.hms.common.service.search.SearchPredicateBuilder;
import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;

public abstract class AbstractSearchPredicateBuilder<T extends BaseSearchVO> implements SearchPredicateBuilder<T> {
	
	protected <N extends Number & Comparable<?>> void addIntervalPredicates(BooleanBuilder builder, N gtValue, N ltValue, NumberPath<N> numberPath) {
		if(gtValue != null) {
			builder.and(numberPath.gt(gtValue));
		}
		if(ltValue != null) {
			builder.and(numberPath.lt(ltValue));
		}
	}
	
	protected void addLikePredicate(BooleanBuilder builder, String value, StringExpression stringExpression) {
		if(StringUtils.isNotBlank(value)) {
			builder.and(stringExpression.containsIgnoreCase(value));
		}
	}
	
	protected <E> void addHasPredicate(BooleanBuilder builder, Boolean value, EntityPathBase<E> entityPath) {
		if(value != null) {
	    	builder.and(value ? entityPath.isNotNull() : entityPath.isNull());
	    }
	}
	
	protected void addInPredicate(BooleanBuilder builder, List<String> values, StringPath stringPath) {
		if(values != null && !values.isEmpty()) {
			builder.and(stringPath.in(values));
		}
	}
	
}
