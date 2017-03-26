package hu.lamsoft.hms.common.service.food.impl;

import org.apache.commons.lang3.StringUtils;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

import hu.lamsoft.hms.common.persistence.food.entity.QFood;
import hu.lamsoft.hms.common.service.food.vo.FoodSearchVO;
import hu.lamsoft.hms.common.service.search.SearchPredicateBuilder;

public class FoodSearchPredicateBuilder implements SearchPredicateBuilder<FoodSearchVO> {

	@Override
	public Predicate build(FoodSearchVO foodSearchVO) {
		BooleanBuilder builder = new BooleanBuilder();
		if(StringUtils.isNotBlank(foodSearchVO.getName())) {
			builder.and(QFood.food.name.containsIgnoreCase(foodSearchVO.getName()));
		}
		if(foodSearchVO.getSugarInGGT() != null) {
			builder.and(QFood.food.sugarInG.doubleValue.gt(foodSearchVO.getSugarInGGT()));
		}
		if(foodSearchVO.getSugarInGLT() != null) {
			builder.and(QFood.food.sugarInG.doubleValue.lt(foodSearchVO.getSugarInGLT()));
		}
		return builder;
	}

}
